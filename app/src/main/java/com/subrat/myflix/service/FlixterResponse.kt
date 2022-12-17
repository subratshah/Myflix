import com.google.gson.annotations.SerializedName
import com.subrat.myflix.model.Movie

data class FlixterResponse(@SerializedName("data") val data: Data)

data class Data(@SerializedName("upcoming") val upcoming: List<Upcoming>)

data class Upcoming(
    @SerializedName("name") val name: String,
    @SerializedName("posterImage") val posterImage: PosterImage,
    @SerializedName("tomatoRating") val tomatoRating: TomatoRating?
)

fun Upcoming.toMovie() = Movie(this.posterImage.url, this.name)

data class PosterImage(@SerializedName("url") val url: String)

data class TomatoRating(@SerializedName("tomatometer") val tomatometer: Int)
