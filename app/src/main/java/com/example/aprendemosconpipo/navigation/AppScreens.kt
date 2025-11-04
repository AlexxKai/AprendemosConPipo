package com.example.aprendemosconpipo.navigation

sealed class AppScreens (val route: String) {
    object PipoP : AppScreens("PipoP")
    object PipoS : AppScreens("PipoS")
    object EjemplosDePipo : AppScreens("EjemplosDePipo")
    object PipoAprende : AppScreens("PipoAprende")
}
