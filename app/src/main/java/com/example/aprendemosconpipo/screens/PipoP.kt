package com.example.aprendemosconpipo.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.aprendemosconpipo.navigation.AppScreens

@Composable
fun PipoP(navController: NavController) {
    Column(
        modifier = Modifier
            .background(Color.LightGray)
            .padding(horizontal = 10.dp, vertical = 30.dp)
            .fillMaxSize()
    ) {
        Button(modifier = Modifier.padding(horizontal = 25.dp, vertical = 100.dp), onClick = {
            navController.navigate(route = AppScreens.PipoS.route)
            println("Botón pulsado")
        }) {
            Text(text = "PipoS")
        }
        repeat(10) {
            Text("Item $it", modifier = Modifier.padding(2.dp))
        }
    }
    Button(modifier = Modifier.padding(horizontal = 25.dp, vertical = 200.dp), onClick = {
        navController.navigate(route = AppScreens.EjemplosDePipo.route)
        println("Botón pulsado")
    }) {
        Text(text = "Ejemplos Pipo")
    }
}
