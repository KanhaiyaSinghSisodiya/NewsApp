package com.example.newsapp.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.newsapp.R
import com.example.newsapp.model.Article

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DemoScreen(list: List<Article>) {
    Scaffold(topBar = {TopBar()}) {
        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .padding(it)) {
            items(items = list, itemContent = {
                    item ->  NewsCard(title = item.title, image = item.urlToImage)
            })
        }
    }
}

@Composable
fun NewsCard(title: String?, image: String?) {
    Card(modifier = Modifier.padding(bottom = 8.dp)){
        Column {
            val ttl = title ?: "null"
            val img = image ?: "null"
            if(img != "null" && ttl != "null") {
                Text(text = ttl, modifier = Modifier.fillMaxWidth())
                AsyncImage(
                    model = img,
                    contentDescription = null,
                    placeholder = painterResource(id = R.drawable.baseline_image_search_24)
                )
            }
        }
    }
}

@Composable
fun TopBar() {
    Row(modifier = Modifier.fillMaxWidth().padding(start = 12.dp, end = 12.dp), horizontalArrangement = Arrangement.SpaceBetween) {
        Text(text = "News", fontSize = 28.sp)
        IconButton(onClick = {  }) {
            Icon(painter = painterResource(id = R.drawable.baseline_search_24), contentDescription = "search")
        }
    }
}