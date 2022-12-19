package com.subrat.myflix.viewModel

import Upcoming
import android.annotation.SuppressLint
import androidx.compose.runtime.mutableStateOf
import androidx.databinding.ObservableField
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.subrat.myflix.model.Category
import com.subrat.myflix.service.FlixsterServiceProvider
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import toMovie

@SuppressLint("CheckResult")
class MainViewModel : ViewModel(), DefaultLifecycleObserver {

    private val flixsterServiceProvider = FlixsterServiceProvider()
    val categoryList = ObservableField<List<Category>>(emptyList())
    val categories = mutableStateOf(listOf<Category>())

    init {
        fetchData()
    }

    private fun fetchData() {
        flixsterServiceProvider.getUpcoming()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map { it.data.upcoming }
            .subscribe(
                ::populateList,
                ::onError
                      )
    }

    private fun populateList(list: List<Upcoming>) {
        val data = list.groupBy { it.tomatoRating?.let { it.tomatometer.div(10) } ?: 5 }
            .toSortedMap(compareByDescending { it })
            .map {
                Category("(${it.value.size})Rated above ${it.key-1}",
                         it.value.map { it.toMovie() })
            }
        categoryList.set(data)
        categories.value = data
    }

    private fun onError(throwable: Throwable) {
        throwable.printStackTrace()
    }
}

class MainViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel() as T
    }
}
