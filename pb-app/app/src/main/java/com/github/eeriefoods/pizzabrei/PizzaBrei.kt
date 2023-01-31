@file:OptIn(ExperimentalFoundationApi::class)

package com.github.eeriefoods.pizzabrei

import android.content.Intent
import android.Manifest
import android.app.DownloadManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import com.github.eeriefoods.pizzabrei.data.repository.ApplicationAPIImpl
import com.github.eeriefoods.pizzabrei.data.repository.ApplicationRepositoryImpl
import com.github.eeriefoods.pizzabrei.data.repository.ReviewAPIImpl
import com.github.eeriefoods.pizzabrei.data.repository.ReviewRepositoryImpl
import com.github.eeriefoods.pizzabrei.domain.usecases.GetApplications
import com.github.eeriefoods.pizzabrei.domain.usecases.GetReviews
import com.github.eeriefoods.pizzabrei.presentation.theme.PizzaBreiTheme
import com.github.eeriefoods.pizzabrei.presentation.ui.navigation.NavGraph
import com.github.eeriefoods.pizzabrei.presentation.ui.views.home.HomeViewModel
import java.io.File
import kotlin.math.absoluteValue

const val APK_MIME_TYPE = "application/vnd.android.package-archive"

@ExperimentalFoundationApi
@ExperimentalComposeUiApi
@ExperimentalMaterial3Api
class PizzaBrei : ComponentActivity() {

    lateinit var downloadManger: DownloadManager

    val requestPermissionLauncher =
        registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { isGranted: Boolean ->
            Log.d("Permissions", "Granted: $isGranted")
        }

    override fun onCreate(savedInstanceState: Bundle?) {

        downloadManger = getSystemService(DOWNLOAD_SERVICE) as DownloadManager

        Log.d("PERMS", "${ContextCompat.checkSelfPermission(this, Manifest.permission.REQUEST_INSTALL_PACKAGES) == PackageManager.PERMISSION_GRANTED}")

        val homeViewModel = HomeViewModel(
            getApplicationsUseCase = GetApplications(
                repository = ApplicationRepositoryImpl(
                    dataSource = ApplicationAPIImpl()
                )
            ),
            getReviewsUseCase = GetReviews(
                repository = ReviewRepositoryImpl(
                    dataSource = ReviewAPIImpl()
                )
            )
        )
        super.onCreate(savedInstanceState)
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)
        setContent {
            PizzaBreiTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavGraph(homeViewModel, this)
                }
            }
        }

        val filter = IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE)
        val downloadReceiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {
                if (intent == null || context == null) return

                val downloadId = intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, -1)
                if (downloadId == -1L) return;

                val cursor = downloadManger.query(DownloadManager.Query().setFilterById(downloadId))
                if (!cursor.moveToFirst()) return;

                val status = cursor.getInt(cursor.getColumnIndex(DownloadManager.COLUMN_STATUS).absoluteValue)

                Log.d("DownloadReceiver", "Status: $status")
                if (status == DownloadManager.STATUS_SUCCESSFUL) {
                    val uri = cursor.getString(cursor.getColumnIndex(DownloadManager.COLUMN_LOCAL_URI).absoluteValue)
                    val file = File(Uri.parse(uri).path!!)
                    Log.d("DownloadReceiver", "Starting Installation...")

                    val uri2 = FileProvider
                        .getUriForFile(context, applicationContext.packageName + ".provider", file)

                    val installIntent = Intent(Intent.ACTION_VIEW)
                    installIntent.setDataAndType(uri2, APK_MIME_TYPE)
                    installIntent.flags = Intent.FLAG_GRANT_READ_URI_PERMISSION
                    installIntent.putExtra(Intent.EXTRA_RETURN_RESULT, true)
                    startActivity(installIntent)
                } else {
                    Toast.makeText(context,  "Download fehlgeschlagen", Toast.LENGTH_LONG).show()
                }

                cursor.close()
            }
        }
        registerReceiver(downloadReceiver, filter)
    }

}
