package com.example.tnytnewsapplication.data.api

import com.example.tnytnewsapplication.data.model.CurrentNews
import com.example.tnytnewsapplication.data.model.Section
import com.example.tnytnewsapplication.data.model.TopNews
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface NewsApi {

    @GET("/svc/topstories/v2/{section}")
    suspend fun getTopStories(
        @Header("Authorization") token: String,
        @Path("section") section: String,

    ) : Response<TopNews>

    @GET("/svc/news/v3/content/section-list")
    suspend fun getAllSections(
        @Header("Authorization") token: String,
        @Path("section") section: String,
    ) : Response<Section>


    @GET("/svc/news/v3/content/{source}/{section}")
    suspend fun getCurrentNews(
        @Header("Authorization") token: String,
        @Path("source") source: String,
        @Path("section") section: String,
        @Query("limit") limit: Integer,
        @Query("offset") offset: Integer
    ) : Response<CurrentNews>
}