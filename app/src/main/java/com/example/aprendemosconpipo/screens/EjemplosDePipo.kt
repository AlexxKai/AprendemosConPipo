package com.example.aprendemosconpipo.screens

//imagen desde local
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
import androidx.compose.runtime.getValue //para usar remember
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue //para usar remember
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
//imagen desde internet, tambien modificar build.gradle.kts:app y en manifiest el xml
import coil.compose.AsyncImage
import com.example.aprendemosconpipo.R
import com.example.aprendemosconpipo.R.string.dados

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EjemplosDePipo(navController: NavController, modifier: Modifier.Companion = Modifier) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                modifier = Modifier.height(60.dp),
                title = {
                    Text(
                        "Aprendemos con Pipo",
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
            listOf("Cuadros iniciales", "Imagenes", "Iconos", "Variable")

//    // Pestañas por categoría
//    val tabsByCategory = listOf(
//        listOf("Buenas"),  // Cuadros iniciales
//        listOf("Saludos"),  // Imagenes
//        listOf("Hola"),  // Iconos
//        listOf("Colores", "Layouts", "Diseño"),  // Botones
//        listOf("jeje"),  // Texto variable
//    )

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

                    3 -> { // Variable
                        when (selectedTabIndex) {
                            0 -> Variable()
                        }
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

// Cuadro para reconocer el texto que mete el usuario
@Composable
fun Variable() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            // Para hacer scroll en la pantalla
            .verticalScroll(rememberScrollState())
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var contador by remember { mutableStateOf(0) }
        Column {
            Text(
                text = "¡El número de golpes es: $contador!",
                style = MaterialTheme.typography.bodyMedium
            )
        }

        Row(
            modifier = Modifier
                .padding(top = 20.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(onClick = { contador++ })
            { Text("Click") }

            FilledTonalButton(onClick = { contador = 0 })
            { Text("Reset") }
        }


        var name by remember { mutableStateOf("") }
        Column {
            if (name.isNotEmpty()) {
                Text(
                    text = "Hola, $name!",
                    modifier = Modifier.padding(bottom = 8.dp),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            Row {
                OutlinedTextField(
                    modifier = Modifier.padding(2.dp),
                    value = name, // Valor actual del campo de texto es la variable name
                    onValueChange = {
                        name = it
                    }, // Actualiza la variable name con el nuevo valor escrito
                    label = { Text("Nombre") } // Etiqueta dentro del campo de texto para indicar qué información debe ingresarse)}
                )
            }
        }
    }
}
