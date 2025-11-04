package com.example.aprendemosconpipo.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.aprendemosconpipo.R
import com.example.aprendemosconpipo.R.string.dados
import com.example.aprendemosconpipo.navigation.AppScreens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PipoAprende(navController: NavController, modifier: Modifier.Companion = Modifier) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                modifier = Modifier.height(60.dp),
                title = {
                    Text(
                        "Pipo Aprende",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = Color.White
                ), navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, "backIcon")
                    }
                }
            )
        }
    ) { innerPadding ->
        var selectedCategoryIndex by remember { mutableIntStateOf(0) }
        var selectedTabIndex by remember { mutableIntStateOf(0) }

        // Categorías principales
        val categories =
            listOf("Lista", "Botones")

        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            // Primera fila: Categorías
            // ScrollableTabRow -> para poder deslizar por la barra
            // ScrollableTabRow -> para ver solo lo que hay
            ScrollableTabRow(
                selectedTabIndex = selectedCategoryIndex,
                containerColor = Color(0xFF6200EE),
                contentColor = Color.White
            ) {
                categories.forEachIndexed { index, title ->
                    Tab(
                        selected = selectedCategoryIndex == index,
                        onClick = {
                            selectedCategoryIndex = index
                            selectedTabIndex = 0 // Resetear al cambiar categoría
                        },
                        text = {
                            Text(
                                text = title,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    )
                }
            }

            // Contenido según la selección
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = Color.DarkGray
            ) {
                when (selectedCategoryIndex) {
                    0 -> { // Formas
                        when (selectedTabIndex) {
                            0 -> Lista()
                        }
                    }

                    1 -> { // Imagenes
                        when (selectedTabIndex) {
                            0 -> Botones()
                        }
                    }
                }
            }
        }
    }
}

data class Mensaje(val titulo: String, val cuerpo: String)

private val mensajes: List<Mensaje> = listOf(
    Mensaje("Título 1", "Descripción 1"),
    Mensaje("Título 2", "Descripción 2"),
    Mensaje("Título 3", "Descripción 3"),
    Mensaje("Título 4", "Descripción 4"),
    Mensaje("Título 5", "Descripción 5")
)

// Cuadros iniciales
@Composable
fun Lista() {


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        // Primer cuadro
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .background(Color.Cyan),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                "Desarrollo en Android",
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                textDecoration = TextDecoration.Underline
            )
        }
        Spacer(Modifier.height(10.dp))

        // Cuadro grados
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(Color.LightGray),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = " DAM",
                fontSize = 13.sp,
                modifier = Modifier
                    .size(70.dp)
                    .background(color = Color.Yellow)
                    .border(3.dp, color = Color.Black)
                    .wrapContentSize(Alignment.CenterStart)
                    .padding(horizontal = 5.dp)
            )

            Text(
                text = "DAW",
                fontSize = 13.sp,
                modifier = Modifier
                    .size(70.dp)
                    .background(color = Color.Green, shape = CircleShape)
                    .border(3.dp, color = Color.Black, shape = CircleShape)
                    .wrapContentSize(Alignment.TopCenter)
                    .padding(top = 5.dp)
            )
            Text(
                text = "ASIR ",
                fontSize = 13.sp,
                modifier = Modifier
                    .size(70.dp)
                    .background(color = Color.Magenta)
                    .border(3.dp, color = Color.Black)
                    .wrapContentSize(Alignment.BottomEnd)
                    .padding(bottom = 5.dp)
            )
        }
    }
}

