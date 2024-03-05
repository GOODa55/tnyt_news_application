package com.example.tnytnewsapplication.data.di

import com.example.tnytnewsapplication.data.api.NewsApi
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.lang.reflect.Array.get
import java.util.concurrent.TimeUnit

private const val BASE_URL = "https://api.nytimes.com"

internal val apiModule = module {
    single {
        val gson = GsonBuilder()
            .setLenient()
            .create()

        val httpClient = OkHttpClient.Builder()
            .readTimeout(30, TimeUnit.SECONDS) // таймаут чтения
            .writeTimeout(30, TimeUnit.SECONDS) // таймаут записи
            .connectTimeout(30, TimeUnit.SECONDS) // таймаут установки соединения
            .addNetworkInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()

        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(httpClient)
            .build()
    }
    single { get<Retrofit>().create<NewsApi>() }
}

