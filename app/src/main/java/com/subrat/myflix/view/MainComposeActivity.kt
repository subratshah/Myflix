package com.subrat.myflix.view

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import com.subrat.myflix.view.ui.theme.MyflixTheme
import com.subrat.myflix.viewModel.MainViewModel
import com.subrat.myflix.viewModel.MainViewModelFactory

class MainComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = ViewModelProvider(this,
                                          MainViewModelFactory())[MainViewModel::class.java]
        setContent {
            MyflixTheme {
                Surface(color = MaterialTheme.colorScheme.surface) {
                    HomeContent(viewModel)
                }
            }
        }
    }
}

@Composable
fun HomeContent(viewModel: MainViewModel) {
    val categoryList by remember { viewModel.categories }
    LazyColumn() {
        items(categoryList) {
            CategoryItem(it)
        }
    }
}

@Preview(name = "LightMode",
         showBackground = true,
         showSystemUi = true)
@Preview(name = "DarkMode",
         showBackground = true,
         showSystemUi = true,
         uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun HomeContentPreview() {
    MyflixTheme {
        HomeContent(MainViewModel())
    }
}