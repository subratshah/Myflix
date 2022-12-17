package com.subrat.myflix.viewModel

import Upcoming
import android.annotation.SuppressLint
import androidx.databinding.ObservableField
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.subrat.myflix.model.Category
import com.subrat.myflix.service.FlixsterServiceProvider
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import toMovie

class MainViewModel : ViewModel(), DefaultLifecycleObserver {

    private val flixsterServiceProvider = FlixsterServiceProvider()
    var categoryList = ObservableField<List<Category>>(emptyList())

    @SuppressLint("CheckResult")
    override fun onCreate(owner: LifecycleOwner) {
        flixsterServiceProvider.getUpcoming()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .map { it.data.upcoming }
            .subscribe(::populateList, ::onError)
    }

    private fun populateList(list: List<Upcoming>) {
        categoryList.set(
            list.groupBy { it.tomatoRating?.let { it.tomatometer.div(10) } ?: 5 }
                .toSortedMap(compareByDescending { it })
                .map {
                    Category("${it.key}0+ Rated(${it.value.size})", it.value.map { it.toMovie() })
                }
        )
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
