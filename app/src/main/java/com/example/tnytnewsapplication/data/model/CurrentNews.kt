package com.example.tnytnewsapplication.data.model

data class CurrentNews(
    val copyright: String,
    val num_results: Int,
    val results: List<CurrentStroy>,
    val status: String
)