package com.example.aprendemosconpipo.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun PipoS(navController: NavController) {
    Column(
        modifier = Modifier
            .background(Color.LightGray)
            .padding(horizontal = 10.dp, vertical = 30.dp)
    ) {
        repeat(20) {
            Text("Item $it", modifier = Modifier.padding(2.dp))
        }
        Button(
            onClick = {
                navController.popBackStack() // Para llevar a cabo la vuelta
                println("Botón pulsado atrás")
            }) {
            Text(text = "Click")
        }
    }
}