package com.example.tnytnewsapplication.data.model

data class CurrentStory(
    val `abstract`: String,
    val byline: String,
    val created_date: String,
    val des_facet: List<String>,
    val first_published_date: String,
    val geo_facet: List<String>,
    val item_type: String,
    val kicker: String,
    val material_type_facet: String,
    val multimedia: List<Multimedia>,
    val org_facet: List<String>,
    val per_facet: List<String>,
    val published_date: String,
    val related_urls: List<Any>,
    val section: String,
    val slug_name: String,
    val source: String,
    val subheadline: String,
    val subsection: String,
    val title: String,
    val updated_date: String,
    val uri: String,
    val url: String
)