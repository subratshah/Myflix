package com.subrat.myflix.viewModel

import Upcoming
import androidx.compose.runtime.mutableStateOf
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.subrat.myflix.model.Category
import com.subrat.myflix.service.FlixterService
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import toMovie
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val flixsterService: FlixterService
) : ViewModel() {

    val categoryList = ObservableField<List<Category>>(emptyList())
    val categories = mutableStateOf(listOf<Category>())

    init {
        flixsterService.getUpcoming()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map { it.data.upcoming }
            .subscribe(
                ::populateList,
                ::onError
            )
    }

    private fun populateList(list: List<Upcoming>) {
        val data = list.groupBy {
            it.tomatoRating?.tomatometer?.div(10) ?: 5
        }
            .toSortedMap(compareByDescending { it })
            .map {
                Category(category = "(${it.value.size})Rated above ${it.key - 1}",
                    movieList = it.value.map { it.toMovie() })
            }
        categoryList.set(data)
        categories.value = data
    }

    private fun onError(throwable: Throwable) {
        throwable.printStackTrace()
    }
}