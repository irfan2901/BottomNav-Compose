package com.example.bottomnavcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bottomnavcompose.screens.AboutScreen
import com.example.bottomnavcompose.screens.BottomNavigationBar
import com.example.bottomnavcompose.screens.HomeScreen
import com.example.bottomnavcompose.screens.SettingsScreen
import com.example.bottomnavcompose.ui.theme.BottomNavComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BottomNavComposeTheme {
                val navController = rememberNavController()
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = { BottomNavigationBar(navController) }) { innerPadding ->
                    NavHost(
                        navController,
                        startDestination = Screens.Home.route,
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable(Screens.Home.route) { HomeScreen(modifier = Modifier) }
                        composable(Screens.About.route) { AboutScreen(modifier = Modifier) }
                        composable(Screens.Settings.route) { SettingsScreen(modifier = Modifier) }
                    }
                }
            }
        }
    }
}