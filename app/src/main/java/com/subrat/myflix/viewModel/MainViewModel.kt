package com.subrat.myflix.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.subrat.myflix.databse.CategoryRepository
import com.subrat.myflix.model.Category
import com.subrat.myflix.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: CategoryRepository
) : ViewModel() {

    val categoryList = ObservableField<List<Category>>(emptyList())
    val categories = mutableStateOf(listOf<Category>())

    init {
        viewModelScope.launch {
            repository.getCategories()
                .onEach { populateList(it) }
        }
    }

    private fun populateList(list: Resource<List<Category>>) {
        val data = list.data
        categoryList.set(data)
        data?.let { categories.value }
    }

    private fun onError(throwable: Throwable) {
        throwable.printStackTrace()
    }
}