package com.example.tnytnewsapplication.data.model

data class TopStory(
    val `abstract`: String,
    val byline: String,
    val created_date: String,
    val des_facet: List<Any>,
    val geo_facet: List<Any>,
    val item_type: String,
    val kicker: String,
    val material_type_facet: String,
    val multimedia: List<Multimedia>,
    val org_facet: List<Any>,
    val per_facet: List<Any>,
    val published_date: String,
    val section: String,
    val short_url: String,
    val subsection: String,
    val title: String,
    val updated_date: String,
    val uri: String,
    val url: String
)