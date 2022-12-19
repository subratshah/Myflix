package com.subrat.myflix.view

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.subrat.myflix.model.Category
import com.subrat.myflix.view.ui.theme.MyflixTheme

@Composable
fun CategoryItem(category: Category) {
    Column(modifier = Modifier.padding(vertical = 5.dp)) {
        Text(
            text = category.category,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(horizontal = 25.dp),
            style = MaterialTheme.typography.headlineMedium
            )
        LazyRow(contentPadding = PaddingValues(vertical = 5.dp)) {
            items(category.movieList) {
                MovieItem(it)
            }
        }
    }
}

@Preview(
    name = "Light",
    showBackground = true
        )
@Preview(
    name = "Dark",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
        )
@Composable
fun CategoryItemPreview() {
    MyflixTheme {
        CategoryItem(
            Category(
                "Category",
                emptyList()
                    )
                    )
    }
}