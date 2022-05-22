package com.example.app_nota

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.dp
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.app_nota.ui.theme.App_notaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App_notaTheme() {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    Greeting()
                }
            }
        }
    }
}

fun sum(nota: Double,nota2: Double,nota3: Double):Double{
    return nota+nota2+nota3/3
}

@Composable
fun Greeting() {
    var nota by remember { mutableStateOf("") }
    var nota2 by remember { mutableStateOf("") }
    var nota3 by remember { mutableStateOf("") }
    var notaf by remember { mutableStateOf(0.0) }
    var calcular = {
        notaf = (nota.toDouble()+nota2.toDouble()+nota3.toDouble())/3
    }



    Surface(modifier = Modifier.padding(vertical = 10.dp, horizontal = 5.dp, )){
        Row(modifier = Modifier.padding(1.dp)){

            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(64.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) {
                Text("Calular nota", fontSize = 50.sp
                    ,fontWeight = FontWeight.Bold)
                TextField(value = nota,
                    onValueChange = {if(it.length<=3)nota= it},
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    label = { Text(text = "Nota 1") },
                    placeholder = { Text(text = "Primera Nota") },
                )

                TextField   (value = nota2,
                    onValueChange = {if(it.length<=3)nota2= it},
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    label = { Text(text = "Nota 2") },
                    placeholder = { Text(text = "Segunda Nota") },
                )

                TextField   (value = nota3,
                    onValueChange = {if(it.length<=3)nota3= it},
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    label = { Text(text = "Nota 3") },
                    placeholder = { Text(text = "Tercera Nota") },
                )


                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 5.dp),
                    onClick = calcular,
                ) {
                    Text("Calcular")
                }

                Text(
                    text = notaf.toString().repeat(1), maxLines = 1,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Gray)
                        .padding(10.dp)


                    ,fontSize = 30.sp
                    ,fontWeight = FontWeight.Bold
                    , color = Color.White
                    ,textAlign = TextAlign.Center
                )
                //Text(notaf.toString() )





            }

        }

        //Text(text = "Hello $name!")
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    App_notaTheme() {
        Greeting()
    }
}