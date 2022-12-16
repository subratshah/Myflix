package com.subrat.myflix.viewModel

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.subrat.myflix.model.MovieDataProvider

class MainViewModel : ViewModel(), LifecycleObserver {

    private val movieDataProvider = MovieDataProvider()
    val categoryList = movieDataProvider.getCategoryList()
}

class MainViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel() as T
    }
}
