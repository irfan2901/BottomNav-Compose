package com.example.bottomnavcompose

sealed class Screens(val route: String) {

    object Home: Screens("home")
    object About: Screens("about")
    object Settings: Screens("settings")

}