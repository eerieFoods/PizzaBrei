@file:OptIn(ExperimentalFoundationApi::class)

package com.github.eeriefoods.pizzabrei

import android.Manifest.permission.WRITE_EXTERNAL_STORAGE
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.core.app.ActivityCompat
import com.github.eeriefoods.pizzabrei.data.DownloadController
import com.github.eeriefoods.pizzabrei.data.repository.ApplicationAPIImpl
import com.github.eeriefoods.pizzabrei.data.repository.ApplicationRepositoryImpl
import com.github.eeriefoods.pizzabrei.data.repository.ReviewAPIImpl
import com.github.eeriefoods.pizzabrei.data.repository.ReviewRepositoryImpl
import com.github.eeriefoods.pizzabrei.domain.usecases.GetApplications
import com.github.eeriefoods.pizzabrei.domain.usecases.GetReviews
import com.github.eeriefoods.pizzabrei.domain.usecases.PutApplication
import com.github.eeriefoods.pizzabrei.domain.usecases.PutReview
import com.github.eeriefoods.pizzabrei.presentation.theme.PizzaBreiTheme
import com.github.eeriefoods.pizzabrei.presentation.ui.views.home.HomeViewModel
import com.github.eeriefoods.pizzabrei.presentation.ui.navigation.NavGraph
import com.github.eeriefoods.pizzabrei.presentation.ui.views.upload.UploadViewModel

@ExperimentalFoundationApi
@ExperimentalComposeUiApi
@ExperimentalMaterial3Api
class PizzaBrei : ComponentActivity() {

    companion object {
        const val PERMISSION_REQUEST_STORAGE = 0
    }

    lateinit var downloadController: DownloadController

    override fun onCreate(savedInstanceState: Bundle?) {

        val apkUrl = "https://androidwave.com/source/apk/app-pagination-recyclerview.apk"
        downloadController = DownloadController(this, apkUrl)

        val uploadViewModel = UploadViewModel(
            putApplicationUseCase = PutApplication(
                repository = ApplicationRepositoryImpl(
                    dataSource = ApplicationAPIImpl()
                )
            ),
            putReviewUseCase = PutReview(
                repository = ReviewRepositoryImpl(
                    dataSource = ReviewAPIImpl()
                )
            )
        )

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
                    NavGraph(homeViewModel, uploadViewModel)
                }
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == PERMISSION_REQUEST_STORAGE) {
            // Request for camera permission.
            if (grantResults.size == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // start downloading
                downloadController.enqueueDownload()
            } else {
                // Permission request was denied.
            }
        }
    }

    private fun checkStoragePermission() {
        // Check if the storage permission has been granted
        if (ActivityCompat.checkSelfPermission(this, WRITE_EXTERNAL_STORAGE) ==
            PackageManager.PERMISSION_GRANTED
        ) {
            // start downloading
            downloadController.enqueueDownload()
        } else {
            // Permission is missing and must be requested.
            requestStoragePermission()
        }
    }
    private fun requestStoragePermission() {
//        if (ActivityCompat.shouldShowRequestPermissionRationale(this, WRITE_EXTERNAL_STORAGE)) {
//                ActivityCompat.requestPermissions(this,
//                    arrayOf(WRITE_EXTERNAL_STORAGE),
//                    PERMISSION_REQUEST_STORAGE
//                )
//        } else {
            ActivityCompat.requestPermissions(this,
                arrayOf(WRITE_EXTERNAL_STORAGE),
                PERMISSION_REQUEST_STORAGE
            )
//        }
    }

}
