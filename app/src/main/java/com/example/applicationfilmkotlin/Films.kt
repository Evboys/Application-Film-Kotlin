package com.example.applicationfilmkotlin

import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.collectAsState
import androidx.compose.foundation.lazy.items


@Composable
fun FilmsScreen(titre: String, viewModel: MainViewModel) {
    val movies by viewModel.movies.collectAsState()
    if (movies.isEmpty()) viewModel.searchMovies(titre)
    LazyColumn {
        items(movies){
            movie -> Text(text = movie.original_title)
        }
    }
}


