package com.example.tnytnewsapplication.data.model

data class TopNews(
    val copyright: String,
    val last_updated: String,
    val num_results: Int,
    val results: List<TopStory>,
    val section: String,
    val status: String
)