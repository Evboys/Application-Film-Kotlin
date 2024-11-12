package com.example.applicationfilmkotlin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MainViewModel: ViewModel() {
    val movies = MutableStateFlow<List<Movies>>(listOf())
    val apikey = "be1ca8af0da3936dcdb2aeaad464d374"
    val service = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
        .create(Api::class.java)

    fun searchMovies(motcle: String){
        viewModelScope.launch{
            movies.value = service.searchmovies(apikey,motcle).results
        }
    }
    fun lastMovies(){
        viewModelScope.launch {
            movies.value = service.lastmovies(apikey).results
        }
    }
}