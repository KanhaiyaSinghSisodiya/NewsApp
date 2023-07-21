package com.example.newsapp.model

import kotlinx.serialization.Serializable

@Serializable
data class NewsDataModel(
    val articles: List<Article>?,
    val status: String?,
    val totalResults: Int?
)