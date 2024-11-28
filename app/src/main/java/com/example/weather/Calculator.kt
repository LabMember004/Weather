import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.weather.MainActivity

@Composable
fun CalculatorPage() {

    Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
        var number by remember { mutableStateOf(0) }
        var number1 by remember { mutableStateOf(0) }
        var operation by remember { mutableStateOf("") }
        var isNewOperation by remember {mutableStateOf(false)}

        Text(
            text="$number",
            fontSize=32.sp,
            modifier=Modifier
            .padding(top=290.dp , start=16.dp , end =120.dp),
            textAlign = TextAlign.End

        )
        

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {

            Column(


            ) {
                Button(onClick = {
                    if(isNewOperation) {
                        number=0
                        isNewOperation=false
                    }
                    number=number *10 +7 }) {
                    Text("7")
                }
                Button(onClick = {
                    if(isNewOperation) {
                        number=0
                        isNewOperation=false
                    }
                    number = number * 10 +4}) {
                    Text("4")
                }
                Button(onClick = {
                    if(isNewOperation) {
                        number=0
                        isNewOperation=false
                    }
                    number= number *10 +1}) {
                    Text("1")
                }
                Button(onClick = {
                    number= if(number>0) number/10 else 0
                }) {
                    Text("<")
                }
            }
            Row() {
                Column(



                ) {
                    Button(onClick = {
                    if(isNewOperation) {
                        number=0
                        isNewOperation=false
                    }
                        number= number*10 +8}) {
                        Text("8")
                    }
                    Button(onClick = {
                        if(isNewOperation) {
                            number=0
                            isNewOperation=false
                        }
                        number= number*10 +5}) {
                        Text("5")
                    }
                    Button(onClick = {
                        if(isNewOperation) {
                            number=0
                            isNewOperation=false
                        }
                        number= number*10 +2}) {
                        Text("2")
                    }
                    Button(onClick = {
                        if(isNewOperation) {
                            number=0
                            isNewOperation=false
                        }
                        number=number*10 +0}) {
                        Text("0")
                    }
                }

                    Column(

                    ) {
                        Button(onClick = {
                            if(isNewOperation) {
                                number=0
                                isNewOperation=false
                            }
                            number= number*10 +9}) {
                            Text("9")
                        }
                        Button(onClick = {
                            if(isNewOperation) {
                                number=0
                                isNewOperation=false
                            }
                            number= number*10 +6}) {
                            Text("6")
                        }
                        Button(onClick = {
                            if(isNewOperation) {
                                number=0
                                isNewOperation=false
                            }
                            number= number*10 +3}) {
                            Text("3")
                        }
                        Button(onClick = {}) {
                            Text(".")
                        }



                }
                Column(

                ) {
                    Button(onClick =  {
                        number1=number
                        operation="/"
                        isNewOperation=false


                        number=0
                    }) {
                        Text("/")
                    }
                    Button(onClick = {
                        number1=number
                        operation = "*"
                        isNewOperation=false

                        number=0
                    }) {
                        Text("X")
                    }
                    Button(onClick = {
                        number1=number
                        operation="+"
                        isNewOperation=false

                        number=0
                    }) {
                        Text("+")
                    }
                    Button(onClick = {
                        number1=number
                        operation="-"
                        isNewOperation=false

                        number=0
                    }) {
                        Text("-")
                    }



                }

            }
            Button(
                onClick = {
                    when(operation) {

                        "+" -> number= number1 +number
                        "-" ->number= number1 -number
                        "*" -> number = number1 * number
                        "/" -> number = if (number !=0 ) number1 / number else 0
                    }
                    operation= ""
                    isNewOperation = true

                },
                modifier = Modifier
                    .padding(top=145.dp , start= 3.dp)
            ) {
                Text(text = "=")
            }


        }

    }
}

@SuppressLint("ComposableDestinationInComposeScope")
@Composable
fun Navigation(navController :NavHostController) {
    NavHost(navController = navController, startDestination="main") {
        composable("main") {
            Box(
                modifier=Modifier.fillMaxWidth()
            ) {
                Button (
                    onClick= {
                        navController.navigate("calculator")

                    },
                    modifier = Modifier.align(Alignment.Center)
                        .padding(top=700.dp)
                ) {
                    Text("Go Back to Weather")
                }
                composable("calculator") {


                }
            }
        }
    }

}

