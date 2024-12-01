package com.example.weather

import CalculatorPage
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeCompilerApi
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key.Companion.Calculator
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.weather.ui.theme.WeatherTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()

            WeatherTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Transparent
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        // Background gradient
                        LinearGradient()

                        // Foreground content
                        MyLocation()
                        TodayWeather()
                        DailyForecast()
                        NavigationGraph(navController = navController)


                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun MyLocation(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 100.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "My Location",
            fontSize = 10.sp,
            color = Color.White
        )
        Text(
            text = "Sulaymaniyah",
            fontSize = 30.sp,
            color = Color.White
        )
        Text(
            text = "21",
            fontSize = 46.sp,
            color = Color.White
        )
        Text(
            text = "Sunny",
            fontSize = 10.sp,
            color = Color.White
        )
    }
}
@Composable
fun TodayWeather(modifier: Modifier = Modifier) {

    val imageModifier = Modifier

        .size(35.dp)


    CompositionLocalProvider(
        LocalTextStyle provides LocalTextStyle.current.copy(color = Color.White)
    ) {
        Box(
            modifier = modifier
                .padding(top=300.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(Color(0xFFB3E5FC).copy(alpha = 0.1f))
                .padding(16.dp)
        ) {
    Column(
        modifier = modifier
            .fillMaxWidth(),

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Row(horizontalArrangement = Arrangement.spacedBy(25.dp)) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            Text("Now")
            Spacer(modifier = Modifier.height(8.dp))

            Image(
                painter = painterResource(id = R.drawable.sunny1),
                contentDescription = "Sunny",
                modifier = imageModifier
            )
            Spacer(modifier = Modifier.height(8.dp))

            Text("22" )
        }

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text("10 AM")
            Spacer(modifier = Modifier.height(8.dp))

            Image(
                painter = painterResource(id = R.drawable.sunny1),
                contentDescription = "Sunny",
                modifier = imageModifier
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text("23")

        }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text ("2 PM")
                Spacer(modifier = Modifier.height(8.dp))
                Image(
                    painter = painterResource(id = R.drawable.sunny1),
                    contentDescription = "Sunny",
                    modifier = imageModifier
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text("24")

            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("6 PM")
                Spacer(modifier = Modifier.height(8.dp))
                Image(
                    painter = painterResource(id = R.drawable.sunny1),
                    contentDescription = "Sunny",
                    modifier = imageModifier
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text("25")


            }

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("10 PM")
                Spacer(modifier = Modifier.height(8.dp))
                Image(
                    painter = painterResource(id = R.drawable.sunny1),
                    contentDescription = "Sunny",
                    modifier = imageModifier
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text("21")

            }
        }
    }
}
}
}

@Composable
fun DailyForecast(modifier: Modifier = Modifier) {
    val imageModifier = Modifier
        .size(35.dp)

    CompositionLocalProvider(
        LocalTextStyle provides LocalTextStyle.current.copy(color = Color.White)
    ) {

    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 500.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color(0xFFB3E5FC).copy(alpha = 0.1f))
            .padding(16.dp)
    )
    {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            @Composable
            fun weatherRow(day: String, temperature: String , extraSpacingBeforeImage : Dp =0.dp) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        day,
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )

                    Spacer(modifier = Modifier.weight(1f))
                    Spacer(modifier= Modifier.width(extraSpacingBeforeImage))
                    Image(
                        painter = painterResource(id = R.drawable.sunny1),
                        contentDescription = "Sunny",
                        modifier = imageModifier

                    )

                    Spacer(modifier = Modifier.weight(1f))

                    Text(
                        temperature,
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                }
            }

            // Add weather rows for different days
            weatherRow("Today", "25" , extraSpacingBeforeImage = 2.dp)
            weatherRow("Tue", "25" , extraSpacingBeforeImage = 20.dp)
            weatherRow("Wed", "25" , extraSpacingBeforeImage = 16.dp)
            weatherRow("Thu", "25" , extraSpacingBeforeImage = 21.dp)
        }
    }
}
}


@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "main") {
        composable("main") {
            MainScreen(navController)
        }
        composable("calculator") {
            CalculatorPage(navController) // Assuming CalculatorPage is defined elsewhere
        }
        composable("imageCard") {
            CardImage(navController)
        }
    }
}

@Composable
fun MainScreen(navController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize()) {
        Button(
            onClick = { navController.navigate("calculator") },
            modifier = Modifier.align(Alignment.Center).padding(top = 700.dp)
        ) {
            Text("Go to Calculator")
        }
        Button(
            onClick = { navController.navigate("imageCard") },
            modifier = Modifier.align(Alignment.Center).padding(top = 800.dp)
        ) {
            Text("Go to Card Image")
        }
    }
}



 

@Composable
fun LinearGradient() {
    val gradient = Brush.linearGradient(
        colors = listOf(
            Color(0xFF0288D1),
            Color(0xFF81D4FA),
            Color(0xFFE3F2FD)
        ),
        start = Offset(0f, 1000f),
        end = Offset(0f, 0f)
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(gradient)
    )
}