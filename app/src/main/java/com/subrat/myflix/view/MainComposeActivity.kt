package com.subrat.myflix.view

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.subrat.myflix.model.MovieDataProvider
import com.subrat.myflix.view.ui.theme.MyflixTheme

class MainComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val data = MovieDataProvider()
        setContent {
            MyflixTheme {
                Surface(color = MaterialTheme.colorScheme.surface) {
                    HomeContent(data)
                }
            }
        }
    }
}

@Composable
fun HomeContent(data: MovieDataProvider) {
    val categoryList = remember { data.getCategoryList() }
    LazyColumn() {
        items(categoryList) {
            CategoryItem(it)
        }
    }
}

@Preview(
        name = "LightMode",
        showBackground = true,
        showSystemUi = true,
        )
@Preview(
        name = "DarkMode",
        showBackground = true,
        showSystemUi = true,
        uiMode = Configuration.UI_MODE_NIGHT_YES,
        )
@Composable
fun HomeContentPreview() {
    MyflixTheme {
        HomeContent(MovieDataProvider())
    }
}