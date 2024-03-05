package com.example.tnytnewsapplication.data.model

data class Section(
    val copyright: String,
    val num_results: Int,
    val results: List<SelectionInfo>,
    val status: String
)