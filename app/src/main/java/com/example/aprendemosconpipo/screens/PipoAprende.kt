package com.example.aprendemosconpipo.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.aprendemosconpipo.R

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
            listOf("Lista", "Ejemplo lista", "Botones", "Carta")

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
                    0 -> { // Lista
                        when (selectedTabIndex) {
                            0 -> Lista()
                        }
                    }

                    1 -> { // Ejemplo lista
                        when (selectedTabIndex) {
                            0 -> JugadoresScreen()
                        }
                    }

                    2 -> { // Botones
                        when (selectedTabIndex) {
                            0 -> Botones()
                        }
                    }

                    3 -> { // Carta
                        when (selectedTabIndex) {
                            0 -> Carta()
                        }
                    }

                }
            }
        }
    }
}

// Ejemplo apuntes de clase, pero modificado
data class Mensaje(
    val titulo: String,
    val descCorta: String,
    val descLarga: String,
    val imagenId: Int
)


//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun EjemploLista() {
//
//    val mensajes: listOf(
//        Mensaje("Título 1", "Descripción 1", R.drawable.lp),
//        Mensaje("Título 2", "Descripción 2", R.drawable.lp),
//        Mensaje("Título 3", "Descripción 3", R.drawable.lp),
//        Mensaje("Título 4", "Descripción 4", R.drawable.lp),
//        Mensaje("Título 5", "Descripción 5", R.drawable.lp)
//    )
//    Column(
//        modifier = Modifier
//            .fillMaxWidth()
//            .fillMaxHeight()
//            .background(Color.DarkGray),
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
////Ejemplo de los apuntes
//        LazyColumn() {
//            //Un item simple
//            item {
//                Text(text = "Primer item")
//            }
//
//            // Añadir 5 items
//            items(5) { index ->
//                Text(text = "Item: $index")
//            }
//
//            // Añadir otro item simple
//            item {
//                Text(text = "Último item")
//            }
//            itemsIndexed(mensajes) { index, mensaje ->
//            }
//        }
//    }
//}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun JugadoresScreen() {
    // Lista de mensajes con información de jugadores de T1
    val mensajes = listOf(
        Mensaje(
            "Doran",
            "Toplaner de T1",
            "Doran es el toplaner de T1. Se unió al equipo a finales de 2024 y ha demostrado ser un jugador sólido con gran capacidad mecánica. Conocido por su pool de campeones diverso y su habilidad para jugar tanto tanques como carries en la línea superior.",
            R.drawable.lp
        ),
        Mensaje(
            "Oner",
            "Jungla de T1",
            "Oner es el jungler de T1. Campeón mundial en 2023 y 2024, es conocido por su excelente visión del juego y capacidad para coordinar ganks con sus compañeros. Su estilo de juego agresivo complementa perfectamente la filosofía del equipo.",
            R.drawable.lp2
        ),
        Mensaje(
            "Faker",
            "Midlaner de T1",
            "Faker, también conocido como 'El Rey Demonio', es considerado el mejor jugador de League of Legends de todos los tiempos. Con 5 campeonatos mundiales y múltiples títulos de la LCK, su legado es incomparable. Su mecánica, visión de juego y liderazgo han definido una era en los esports.",
            R.drawable.lp2
        ),
        Mensaje(
            "Gumayusi",
            "ADC de T1",
            "Gumayusi es el ADC de T1. Campeón mundial en 2023 y 2024, destaca por su agresividad en la línea y su capacidad para llevar partidas en las fases tardías. Su química con Keria forma una de las mejores botlanes del mundo.",
            R.drawable.lp2
        ),
        Mensaje(
            "Keria",
            "Support de T1",
            "Keria es el support de T1 y campeón mundial en 2023 y 2024. Reconocido por su creatividad y mecánica excepcional, revoluciona constantemente el rol de support con picks innovadores. Su roaming y visión del mapa son elementos clave en el éxito de T1.",
            R.drawable.lp2
        )
    )

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "T1 - Jugadores",
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp,
                        color = Color.White
                    )
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color(0xFFE6002D)
                )
            )
        },
        containerColor = Color.Black
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            itemsIndexed(mensajes) { index, mensaje ->
                JugadorItem(mensaje = mensaje, index = index)

                if (index < mensajes.size - 1) {
                    HorizontalDivider(
                        modifier = Modifier.padding(horizontal = 16.dp),
                        thickness = 1.dp,
                        color = Color(0xFFE6002D).copy(alpha = 0.4f)
                    )
                }
            }
        }
    }
}

@Composable
fun JugadorItem(mensaje: Mensaje, index: Int) {
    var expanded by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 16.dp)
            .clickable { expanded = !expanded }
    ) {
        Row(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = mensaje.imagenId),
                contentDescription = "Imagen de ${mensaje.titulo}",
                modifier = Modifier
                    .size(80.dp)
                    .clip(CircleShape)
                    .border(2.dp, Color(0xFFE6002D), CircleShape)
            )
            Column(
                modifier = Modifier
                    .padding(start = 16.dp)
                    .weight(1f)
            ) {
                Text(
                    text = mensaje.titulo,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color.Black
                )
                Text(
                    text = mensaje.descCorta,
                    fontSize = 14.sp,
                    color = Color.Gray
                )
                AnimatedVisibility(visible = expanded) {
                    Text(
                        text = mensaje.descLarga,
                        modifier = Modifier.padding(top = 8.dp),
                        fontSize = 14.sp,
                        color = Color.DarkGray
                    )
                }
            }
        }
    }
}

// Lista
@Composable
fun Lista() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color.DarkGray),
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        //Cuandro para entregar
        LazyColumn(
        ) {
            //Un item simple
            item {
                Row(
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start,
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.lp2),
                        contentDescription = "Imagen cargada en local",
                        modifier = Modifier
                            .clip(CircleShape)
                            .border(shape = CircleShape, width = 2.dp, color = Color.Black)
                            .size(100.dp),
                    )
                    var expanded by remember { mutableStateOf(false) }
                    val patata: String = LoremIpsum(200).values.first().toString()
                    Column(
                        modifier = Modifier
                            //.fillMaxSize()
                            .clickable { expanded = !expanded }) {
                        Text(
                            text = "Linkin Park",
                            color = Color.White
                        )
                        AnimatedVisibility(!expanded) {
                            Text(
                                text = "hola",
                                color = Color.Magenta
                            )
                        }
                        AnimatedVisibility(expanded) {
                            Text(
                                text = patata,
                                color = Color.Magenta,
                            )
                        }
//                        Text(
//                            text = patata,
//                            color = Color.Magenta,
//                            maxLines = if (expanded) Int.MAX_VALUE else 1
//                        )
                    }
                }

            }
        }
    }
}

@Composable
fun Carta() {
    Card {
        var expanded by remember { mutableStateOf(false) }
        Column(Modifier.clickable { expanded = !expanded }) {
            Image(
                painter = painterResource(R.drawable.lp2),
                contentDescription = "Imagen cargada en local",
            )
            AnimatedVisibility(expanded) {
                Text(
                    text = "Linkin Park",
                    style = MaterialTheme.typography.bodyLarge,
                )
            }
        }
    }
}
