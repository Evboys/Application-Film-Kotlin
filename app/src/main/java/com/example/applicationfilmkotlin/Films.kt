package com.example.applicationfilmkotlin

import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.collectAsState
import androidx.compose.foundation.lazy.items
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun FilmsScreen() {
    val viewModel : MainViewModel = viewModel()
    val movies by viewModel.movies.collectAsState()
    if (movies.isEmpty()) viewModel.lastMovies()
    LazyColumn {
        items(movies){
            movie -> Text(text = movie.original_title)
        }
    }
}


