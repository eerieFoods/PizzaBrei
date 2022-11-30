package com.github.eeriefoods.pizzabrei

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.eeriefoods.pizzabrei.ui.theme.PizzaBreiTheme
import java.time.LocalTime

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PizzaBreiTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //Greeting("Android")
                    ListApps("COC")
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    Scaffold(
        topBar = { Top}
    )
}

@Composable
fun AppCard(){

}

@Composable
fun ButtonNavigationBar(){

}

@Composable
fun ListApps(name: String) {
    Box{
        Row() {
            Image(
                painterResource(R.drawable.ic_launcher_foreground),
                "Home-button",
                Modifier.border(1.5.dp, MaterialTheme.colorScheme.primary))
            Column{
                Text("Name: $name!")
                Text("Time: ${LocalTime.now()}")
                TextButton(onClick = { /*TODO*/ }) {
                    Text("alloha")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PizzaBreiTheme {
        MainScreen()
    }
}