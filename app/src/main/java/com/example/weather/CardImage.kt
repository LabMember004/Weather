package com.example.weather

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.weather.MainActivity



@Composable
fun CardImage(navController: NavHostController) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            val painter = painterResource(id = R.drawable.kermit)
            val description = "Kermit looks at you suspiciously"
            val title = "Kermit"
            Box (modifier = Modifier
                .fillMaxWidth(0.5f)
                .padding(16.dp)) {
            ImageCard(
                painter=painter,
                contentDescription = description ,
                title= title

            )
            }

            Button(
                onClick = { navController.popBackStack() },
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(16.dp)
            ) {
                Text("Go Back")
            }
        }
    }
}
@Preview
@Composable
fun ImageCard(painter: Painter, contentDescription: String, title: String, modifier : Modifier = Modifier) {
   Card(
       modifier=modifier.fillMaxWidth(),
       shape = RoundedCornerShape(15.dp),
   ) {
       Box(
           modifier = Modifier.height(200.dp)

       ) {
           Image(
               painter=painter,
               contentDescription = contentDescription,
               contentScale= ContentScale.Crop,
               modifier = Modifier.fillMaxSize()
           )
           Box(modifier = Modifier
               .fillMaxSize()
               .background (
                   Brush.verticalGradient(
                       colors = listOf(
                           Color.Transparent,
                           Color.Black
                       ),
                       startY = 300f
                   )
               ))
           Box (
               modifier = Modifier
                   .fillMaxSize()
                    .padding(12.dp),

               contentAlignment = Alignment.BottomCenter ,


           ) {
               Column (
                   horizontalAlignment = Alignment.CenterHorizontally
               ) {
               Text(
                   title,
                   style = TextStyle (color = Color.White , fontSize = 16.sp),
                   textAlign = TextAlign.Center
               )
                   Spacer(modifier = Modifier.height(4.dp))
                   Text(
                       contentDescription,
                       style = TextStyle (color = Color.White , fontSize = 14.sp),
                       textAlign = TextAlign.Center
                   )

       }
       }
       }
   }

}