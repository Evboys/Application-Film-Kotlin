package com.example.applicationfilmkotlin

data class TmdbMovieResult(
    val page: Int,
    val results: List<Movies>,
    val total_pages: Int,
    val total_results: Int
)

data class Movies(
    val adult: Boolean,
    val backdrop_path: Any,
    val genre_ids: List<Int>,
    val id: Int,
    val original_language: String,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val release_date: String,
    val title: String,
    val video: Boolean,
    val vote_average: Int,
    val vote_count: Int
)