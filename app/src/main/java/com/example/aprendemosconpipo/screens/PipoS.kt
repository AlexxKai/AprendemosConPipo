package com.example.aprendemosconpipo.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class) // Needed for TopAppBar
@Composable
fun PipoS(navController: NavController, text: String?) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                modifier = Modifier.height(60.dp),
                title = {
                    Text(
                        "Segunda ventana",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = Color.White
                )
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .background(Color.LightGray)
                .fillMaxSize()
                .padding(innerPadding),
            //.padding(horizontal = 10.dp, vertical = 30.dp)
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Button(
                onClick = {
                    navController.popBackStack() // Para llevar a cabo la vuelta
                    println("Botón pulsado atrás")
                }) {
                Text(text = "Volver atrás")
            }
            text?.let {
                Text(it)
            }
            repeat(20) {
                Text(
                    "Item $it",
                    modifier = Modifier.padding(2.dp)
                )
            }
        }
    }
}
