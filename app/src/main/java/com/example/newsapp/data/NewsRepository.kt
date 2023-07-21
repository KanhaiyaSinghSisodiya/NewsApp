package com.example.newsapp.data

import com.example.newsapp.model.NewsDataModel
import com.example.newsapp.network.NewsApi
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface NewsRepository {
    suspend fun getNews():NewsDataModel
}

class NetworkNewsRepository: NewsRepository{

    private val url: String = "https://newsapi.org/v2/"

    private val json = Json {
        ignoreUnknownKeys = true
        coerceInputValues = true
    }







    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(url)
        .build()

    private val retrofitService: NewsApi by lazy {
        retrofit.create(NewsApi::class.java)
    }
    override suspend fun getNews(): NewsDataModel {
        return retrofitService.getNews()
    }

}