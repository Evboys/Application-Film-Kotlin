package com.example.applicationfilmkotlin


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import com.example.applicationfilmkotlin.ui.theme.ApplicationFilmKotlinTheme
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.getValue
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.Serializable



@Serializable class Films
@Serializable class Series
@Serializable class Acteurs



class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentDestination = navBackStackEntry?.destination
            val windowSizeClass = currentWindowAdaptiveInfo().windowSizeClass

            ApplicationFilmKotlinTheme {
                Scaffold( modifier = Modifier.fillMaxSize(),topBar = {
                    TopAppBar(
                        title = {
                            Text(text = "FilmsDetails")
                        },
                        actions = {
                            IconButton(onClick = {  }) {
                                Icon(Icons.Filled.Search, contentDescription = "Search")
                            }
                        },
                    )
                },bottomBar = {



                    NavigationBar {
                        NavigationBarItem(
                            icon = { Icon(imageVector = Icons.Default.AccountCircle , contentDescription = "Affichage de film" ) }, label = { Text("Films") },
                            selected = currentDestination?.hasRoute<Films>() == true,
                            onClick = { navController.navigate(Films()) })
                        NavigationBarItem(
                            icon = { Icon(imageVector = Icons.Default.Edit , contentDescription = "Affichage de series" ) }, label = { Text("Series") },
                            selected = currentDestination?.hasRoute<Series>() == true,
                            onClick = { navController.navigate(Series()) })
                        NavigationBarItem(
                            icon = { Icon(imageVector = Icons.Default.Edit , contentDescription = "Affichage des acteurs" ) }, label = { Text("Acteurs") },
                            selected = currentDestination?.hasRoute<Acteurs>() == true,
                            onClick = { navController.navigate(Acteurs()) })
                    }
                })
                { innerPadding ->
                    NavHost(navController= navController, startDestination = Series(),
                        Modifier.padding(innerPadding)) {
                        composable<Films> { FilmsScreen() }
                        composable<Series> { SeriesScreen() }
                        composable<Acteurs> { ActeursScreen() }

                    }
                }
            }
        }
    }
}

