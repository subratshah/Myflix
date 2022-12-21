import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.subrat.myflix.model.Category
import com.subrat.myflix.model.Movie

data class FlixterResponse(@SerializedName("data") val data: Data)

data class Data(@SerializedName("upcoming") val upcoming: List<Upcoming>)

data class Upcoming(
    @PrimaryKey
    @SerializedName("movieName") val name: String,
    @SerializedName("posterImage") val posterImage: PosterImage,
    @SerializedName("tomatoRating") val tomatoRating: TomatoRating?
)

data class PosterImage(@SerializedName("url") val url: String)

data class TomatoRating(@SerializedName("tomatometer") val tomatometer: Int)

fun Upcoming.toMovie() = Movie(this.posterImage.url, this.name)

fun List<Upcoming>.toCategories() = this
    .groupBy {
        it.tomatoRating?.tomatometer?.div(10) ?: 5
    }
    .toSortedMap(compareByDescending { it })
    .map {
        Category(categoryName = "(${it.value.size})Rated above ${it.key - 1}",
            movieList = it.value.map { it.toMovie() })
    }
