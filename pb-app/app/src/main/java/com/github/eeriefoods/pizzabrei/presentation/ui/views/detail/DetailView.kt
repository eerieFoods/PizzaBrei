package com.github.eeriefoods.pizzabrei.presentation.ui.views.detail

import android.view.MotionEvent
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.github.eeriefoods.pizzabrei.R
import com.github.eeriefoods.pizzabrei.presentation.theme.PizzaBreiTheme
import com.github.eeriefoods.pizzabrei.presentation.ui.navigation.Views
import com.github.eeriefoods.pizzabrei.presentation.ui.views.home.HomeViewModel


@ExperimentalComposeUiApi
@Composable
fun DetailView(viewModel: HomeViewModel, navController: NavController) {
     val application = viewModel.selectedApp
    PizzaBreiTheme {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(5.dp),
        ) {

            item {
                Text(text = application.name!!, fontSize = 30.sp)
            }
            item {
                Text(text = application.authors!!, fontSize = 18.sp)
            }
            item {
                Text(text = application.version!!, fontSize = 18.sp)
            }

            item {
                Image(
                    painter = painterResource(id = R.mipmap.bild),
                    contentDescription = "Head Picture",
                    modifier = Modifier.fillMaxSize()
                )

            }

            item {
                Button(onClick = {
                    //TODO
                },
                Modifier.padding(20.dp)) {
                    Text("Installieren", fontSize = 20.sp)
                }
            }
            
            
            item { 
                Text(text = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet")
            }


            item {
                RatingBar(rating = 3)
            }


            item {
                Text(text = "Downloads: 3", fontSize = 18.sp)
            }


            item {
                Button(onClick = {
                    navController.navigateUp()
                },
                    Modifier.padding(20.dp)) {
                    Text("Zur??ck")
                }
            }


        }
        
    }

}

/*
 @Composable
 fun RatingBar(
     modifier: Modifier = Modifier,
     rating: Double = 0.0,
     stars: Int = 5,
     starsColor: Color = Color.YELLOW,
 ) {

     val filledStars = floor(rating).toInt()
     val unfilledStars = (stars - ceil(rating)).toInt()


     Row(modifier = modifier) {
         repeat(filledStars) {
             Icon(imageVector = Icons.Outlined.Star, contentDescription = null, tint = starsColor)
         }



         repeat(unfilledStars) {
             Icon(
                 imageVector = Icons.Outlined.StarOutline,
                 contentDescription = null,
                 tint = starsColor
             )
         }
     }
 }

*/

 @ExperimentalComposeUiApi
 @Composable
 fun RatingBar(
     modifier: Modifier = Modifier,
     rating: Int
 ) {
     var ratingState by remember {
         mutableStateOf(rating)
     }

     var selected by remember {
         mutableStateOf(false)
     }
     val size by animateDpAsState(
         targetValue = if (selected) 72.dp else 64.dp,
         spring(Spring.DampingRatioMediumBouncy)
     )

     Row(
         modifier = Modifier.fillMaxSize(),
         verticalAlignment = Alignment.CenterVertically,
         horizontalArrangement = Arrangement.Center
     ) {
         for (i in 1..5) {
             Icon(
                 painter = painterResource(id = R.drawable.star_black),
                 contentDescription = "star",
                 tint= if(i <= ratingState) Color.Yellow else Color.Black,
                 modifier = modifier
                     .width(size)
                     .height(size)
                     .pointerInteropFilter {
                         when (it.action) {
                             MotionEvent.ACTION_DOWN -> {
                                 selected = true
                                 ratingState = i
                             }
                             MotionEvent.ACTION_UP -> {
                                 selected = false
                             }
                         }
                         true
                     }

             )
         }
     }
 }




