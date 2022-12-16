import com.google.gson.annotations.SerializedName
import com.subrat.myflix.model.Movie

data class FlixterResponse(@SerializedName("data") val data: Data)

data class Data(@SerializedName("upcoming") val upcoming: List<Upcoming>)

data class Upcoming(
    @SerializedName("name") val name: String,
    @SerializedName("releaseDate") val releaseDate: String,
    @SerializedName("posterImage") val posterImage: PosterImage
)

data class PosterImage(@SerializedName("url") val url: String)

fun Upcoming.toMovie() = Movie(this.posterImage.url, this.name)
