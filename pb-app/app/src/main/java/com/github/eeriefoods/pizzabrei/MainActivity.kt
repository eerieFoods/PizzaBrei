package com.github.eeriefoods.pizzabrei

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.ui.Modifier
import com.github.eeriefoods.pizzabrei.data.repository.ApplicationAPIImpl
import com.github.eeriefoods.pizzabrei.data.repository.ApplicationRepositoryImpl
import com.github.eeriefoods.pizzabrei.domain.usecases.GetApplications
import com.github.eeriefoods.pizzabrei.presentation.ui.navigation.NavGraph
import com.github.eeriefoods.pizzabrei.presentation.theme.PizzaBreiTheme
import com.github.eeriefoods.pizzabrei.presentation.ui.home.HomeViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val viewModel = HomeViewModel(
            getApplicationsUseCase = GetApplications(
                repository = ApplicationRepositoryImpl(
                    dataSource = ApplicationAPIImpl()
                )
            )
        )
        super.onCreate(savedInstanceState)
        setContent {
            PizzaBreiTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NavGraph(viewModel)
                }
            }
        }
    }
}
