package com.example.aprendemosconpipo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
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
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.aprendemosconpipo.R.string.dados
import com.example.aprendemosconpipo.ui.theme.AprendemosConPipoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AprendemosConPipoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    PantallaPrincipal(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun PantallaPrincipal(modifier: Modifier = Modifier) {
    var selectedCategoryIndex by remember { mutableIntStateOf(0) }
    var selectedTabIndex by remember { mutableIntStateOf(0) }

    // Categorías principales
    val categories = listOf("Cuadros iniciales", "Imagenes", "Iconos", "Botones", "Texto variable")

//    // Pestañas por categoría
//    val tabsByCategory = listOf(
//        listOf("Buenas"),  // Cuadros iniciales
//        listOf("Saludos"),  // Imagenes
//        listOf("Hola"),  // Iconos
//        listOf("Colores", "Layouts", "Diseño"),  // Botones
//        listOf("jeje"),  // Texto variable
//    )

    Column(modifier = modifier.fillMaxSize()) {
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
                    text = { Text(text = title, fontSize = 14.sp, fontWeight = FontWeight.Bold) }
                )
            }
        }

//        // Segunda fila: Pestañas de la categoría seleccionada
//        TabRow(
//            selectedTabIndex = selectedTabIndex,
//            containerColor = Color(0xFF7C4DFF),
//            contentColor = Color.White,
//            modifier = Modifier.horizontalScroll(rememberScrollState())
//        ) {
//            tabsByCategory[selectedCategoryIndex].forEachIndexed { index, title ->
//                Tab(
//                    selected = selectedTabIndex == index,
//                    onClick = { selectedTabIndex = index },
//                    text = { Text(text = title, fontSize = 12.sp) }
//                )
//            }
//        }

        // Contenido según la selección
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.DarkGray
        ) {
            when (selectedCategoryIndex) {
                0 -> { // Formas
                    when (selectedTabIndex) {
                        0 -> Formas()
                    }
                }

                1 -> { // Imagenes
                    when (selectedTabIndex) {
                        0 -> Imagenes()
                    }
                }

                2 -> { // Iconos
                    when (selectedTabIndex) {
                        0 -> Iconos()
                    }
                }

                3 -> { // Botones
                    when (selectedTabIndex) {
                        0 -> Botones()
                    }
                }

                4 -> { // TextoVariable
                    when (selectedTabIndex) {
                        0 -> TextoVariable()
                    }
                }

            }
        }
    }
}

// Cuadros iniciales
@Composable
fun Formas() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(24.dp)
            // Para hacer scroll en la pantalla
            .verticalScroll(rememberScrollState())
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

// Meter imagenes
@Composable
fun Imagenes() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(24.dp)
            // Para hacer scroll en la pantalla
            .verticalScroll(rememberScrollState())
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Imagen local
        Image(
            painter = painterResource(id = R.drawable.yo),
            contentDescription = "Imagen cargada en local"
        )
        // Imagen desde internet, tambien modificar build.gradle.kts:app y en manifiest el xml
        AsyncImage(
            model = "https://media.istockphoto.com/id/613872668/es/foto/jack-o-linterna.webp?s=2048x2048&w=is&k=20&c=PY3vLknAGzgXpq2W1V0IUM2UoLxinvP5gJf0opjaEvw=",
            contentDescription = "Imagen de una calabaza"
        )
    }
}

// Diferentes iconos
@Composable
fun Iconos() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(24.dp)
            // Para hacer scroll en la pantalla
            .verticalScroll(rememberScrollState())
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //Iconos
        Icon(
            //painter=painterResource(R.drawable.dados),
            modifier = Modifier
                .size(200.dp, 200.dp),
            imageVector = Icons.Filled.Star,
            contentDescription = stringResource(id = dados),
            tint = Color.Red
        )

        Icon(
            //painter=painterResource(R.drawable.dados),
            modifier = Modifier
                .size(200.dp, 200.dp),
            imageVector = Icons.Filled.Delete,
            //para meter content description en string, tengo que crearlo en res/values/strings.xml
            contentDescription = stringResource(id = dados),
        )
    }
}

//Botones
@Composable
fun Botones() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(24.dp)
            // Para hacer scroll en la pantalla
            .verticalScroll(rememberScrollState())
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .padding(top = 20.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Button(onClick = { })
            { Text("Filled") }

            FilledTonalButton(onClick = { })
            { Text("Tonal") }

            OutlinedButton(onClick = { })
            { Text("Outlined") }
        }

        Row(
            modifier = Modifier
                .padding(top = 20.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            ElevatedButton(onClick = { })
            { Text("Elevated") }

            TextButton(onClick = { })
            { Text("Text Button") }
        }

        Row(
            modifier = Modifier
                .padding(top = 20.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            FloatingActionButton(onClick = { })
            { Icon(Icons.Filled.Add, "Floating action button.") }

            SmallFloatingActionButton(
                onClick = {},
                containerColor = MaterialTheme.colorScheme.secondaryContainer,
                contentColor = MaterialTheme.colorScheme.secondary
            )
            {
                Icon(Icons.Filled.Add, "Small floating action button.")
            }

            LargeFloatingActionButton(
                onClick = {},
                shape = CircleShape,
            )
            { Icon(Icons.Filled.Add, "Large floating action button") }


            ExtendedFloatingActionButton(
                onClick = {},
                icon = { Icon(Icons.Filled.Edit, "Extended floating action button.") },
                text = { Text(text = "Extended FAB") },
            )
        }

        Column(modifier = Modifier.padding(16.dp)) {
            var name by remember { mutableStateOf("") }
            if (name.isNotEmpty()) {
                Text(
                    text = "Hola, $name!",
                    modifier = Modifier.padding(bottom = 8.dp),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            OutlinedTextField(
                value = name, // Valor actual del campo de texto es la variable name
                onValueChange = {
                    name = it
                }, // Actualiza la variable name con el nuevo valor escrito
                label = { Text("Nombre") } // Etiqueta dentro del campo de texto para indicarquéinformacióndebeingresarse)}
            )
        }
    }
}

// Cuadro para reconocer el texto que mete el usuario
@Composable
fun TextoVariable() {
    Column(modifier = Modifier.padding(16.dp)) {
        var name by remember { mutableStateOf("") }
        if (name.isNotEmpty()) {
            Text(
                text = "Hola, $name!",
                modifier = Modifier.padding(bottom = 8.dp),
                style = MaterialTheme.typography.bodyMedium
            )
        }
        OutlinedTextField(
            value = name, // Valor actual del campo de texto es la variable name
            onValueChange = {
                name = it
            }, // Actualiza la variable name con el nuevo valor escrito
            label = { Text("Nombre") } // Etiqueta dentro del campo de texto para indicarquéinformacióndebeingresarse)}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AprendemosConPipoTheme {
        PantallaPrincipal()
    }
}