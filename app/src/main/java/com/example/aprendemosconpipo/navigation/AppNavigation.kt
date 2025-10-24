package com.example.aprendemosconpipo.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.aprendemosconpipo.screens.EjemplosDePipo
import com.example.aprendemosconpipo.screens.PipoP
import com.example.aprendemosconpipo.screens.PipoS

@Composable
fun AppNavigation(modifier: Modifier) {
    val navController =
        rememberNavController() //Constante que se propagará a todas las pantallas, encargada
    //de gestionar cuál es el estado de navegación entre ellas para poder desplazarse entre ellas.
    NavHost(
        navController = navController,
        startDestination = AppScreens.PipoP.route
    ) { //NavHost con las dos propiedades de conocer: las pantallas ( navContoller ) y cómo navegar
        // entre ellas (ruta de inicio), es decir, cuando arranque la app a que pantalla irá.
        // Por ello, llamamos a AppScreens que tenemos las rutas de cada pantalla.
        composable(route = AppScreens.PipoP.route) { //Dentro del NavHost tenemos distintos composables que
            //designan a cada una de las pantallas. Dentro asignamos la ruta de la pantalla(AppScreens.PipoP.route)
            PipoP(navController)
        } //Se pasa como argumento navController para poder conocer su estado y
        //gestionar la navegación, por lo que es necesario modificar las funciones creadas en cada una de las ventanas.
        composable(route = AppScreens.PipoS.route) {
            PipoS(navController)
        }
        composable(route = AppScreens.EjemplosDePipo.route) {
            EjemplosDePipo(navController)
        }
    }
}