package com.example.newsapp

import android.annotation.SuppressLint
import android.net.Network
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.tooling.preview.Preview
import com.example.newsapp.data.NetworkNewsRepository
import com.example.newsapp.data.NewsRepository
import com.example.newsapp.model.Article
import com.example.newsapp.model.NewsDataModel
import com.example.newsapp.ui.theme.DemoScreen
import com.example.newsapp.ui.theme.NewsAppTheme
import kotlinx.coroutines.coroutineScope

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    var ob: NewsDataModel by remember {
                        mutableStateOf(NewsDataModel(null,null,null))
                    }
                    val api = NetworkNewsRepository()
                    LaunchedEffect(api) {
                          try {
                             coroutineScope {
                                 ob = api.getNews()
                                 Log.d("jj","ghh")
                             }
                         } catch (e: Exception){
                              Log.d("jvhjvhjj","ghkhh")

                          }
                    }
                    if(ob.articles!=null) DemoScreen(ob.articles!!)
                    else Greeting(name = "NO News")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}
