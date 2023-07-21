package com.example.newsapp.network

import com.example.newsapp.model.NewsDataModel
import retrofit2.http.GET


interface NewsApi {

    @GET("everything?q=usa&apiKey=58b1dc87aef542ada7203b631e5f7650")
    suspend fun getNews(): NewsDataModel
}