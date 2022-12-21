package com.subrat.myflix.view

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.subrat.myflix.model.Movie
import com.subrat.myflix.view.ui.theme.MyflixTheme

@OptIn(ExperimentalCoilApi::class)
@Composable
fun MovieItem(movie: Movie) {
    Card(
        elevation = CardDefaults.cardElevation(100.dp),
        modifier = Modifier.padding(5.dp)
        ) {
        Row(
            modifier = Modifier.padding(5.dp),
           ) {
            Column {
                Card(
                    modifier = Modifier
                        .width(150.dp)
                        .height(250.dp)
                        .padding(2.dp),
                    shape = RoundedCornerShape(corner = CornerSize(10.dp))
                    ) {
                    Image(
                        painter = rememberImagePainter(movie.imageUrl),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                         )
                }
                Text(
                    text = movie.movieName,
                    color = MaterialTheme.colorScheme.secondary,
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier
                        .padding(start = 10.dp)
                        .width(140.dp),
                    maxLines = 1
                    )
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
    uiMode = Configuration.UI_MODE_NIGHT_YES,
        )
@Composable
fun MovieItemPreview() {
    MyflixTheme {
        MovieItem(
            Movie(
                "url",
                "Movie"
                 )
                 )
    }
}