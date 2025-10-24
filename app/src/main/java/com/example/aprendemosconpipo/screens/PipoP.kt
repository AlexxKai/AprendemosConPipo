package com.example.aprendemosconpipo.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
                title = {
                    Text(
                        "Primera ventana",
                        fontWeight = FontWeight.Bold
                    )
                }
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
                    .padding(top = 20.dp)
                    .fillMaxWidth()
                    .background(Color.LightGray),
                horizontalArrangement = Arrangement.SpaceBetween
            )
            {
                Button(
                    modifier = Modifier
                        .padding(horizontal = 25.dp, vertical = 50.dp),
                    onClick = {
                        navController.navigate(route = AppScreens.EjemplosDePipo.route)
                        println("Botón pulsado")
                    }) {
                    Text(text = "Ejemplos Pipo")
                }
                Button(
                    modifier = Modifier
                        .padding(horizontal = 50.dp, vertical = 50.dp),
                    onClick = {
                        navController.navigate(route = AppScreens.PipoS.route)
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
