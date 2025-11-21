package com.example.aprendemosconpipo.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.aprendemosconpipo.navigation.AppScreens

@OptIn(ExperimentalMaterial3Api::class) // Needed for TopAppBar
@Composable
fun PipoP(navController: NavController) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                modifier = Modifier.height(60.dp),
                title = {
                    Text(
                        "Primera ventana",
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
                //.padding(horizontal = 10.dp, vertical = 30.dp)
                .fillMaxSize()
                .fillMaxWidth()
                .fillMaxHeight()
                .verticalScroll(rememberScrollState())
                .padding(innerPadding)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.LightGray),
                horizontalArrangement = Arrangement.SpaceBetween
            )
            {
                Button(
                    modifier = Modifier
                        .padding(horizontal = 25.dp, vertical = 10.dp),
                    onClick = {
                        navController.navigate(route = AppScreens.EjemplosDePipo.route)
                        println("Botón pulsado")
                    }) {
                    Text(text = "Ejemplos Pipo")
                }
                Button(
                    modifier = Modifier
                        .padding(horizontal = 25.dp, vertical = 10.dp),
                    onClick = {
                        navController.navigate(route = AppScreens.PipoAprende.route)
                        println("Botón pulsado")
                    }) {
                    Text(text = "Pipo Aprende")
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.LightGray),
                horizontalArrangement = Arrangement.Center
            )
            {
                Button(
                    modifier = Modifier
                        .padding(horizontal = 50.dp, vertical = 10.dp),
                    onClick = {
                        navController.navigate(route = AppScreens.PipoS.route+"/Hola buenas"+"/Saludiiiitos")
                        println("Botón pulsado")
                    }) {
                    Text(text = "PipoS")
                }
            }

            repeat(10) {
                Text(
                    "Item $it",
                )
            }

        }
    }
}
