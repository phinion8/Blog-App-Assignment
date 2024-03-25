package com.phinion.bloggy.ui.screens.home.viewmodel

import android.util.Log
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.phinion.bloggy.domain.models.BlogItem
import com.phinion.bloggy.domain.use_cases.UseCases
import com.phinion.bloggy.utils.Constants.PAGE_SIZE
import com.phinion.bloggy.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val useCases: UseCases
) : ViewModel() {

    val blogList = mutableStateListOf<BlogItem>()
    private var page by mutableIntStateOf(1)
    var canPaginate by mutableStateOf(false)
    var blogListState by mutableStateOf(BlogListState.IDLE)
    var error by mutableStateOf("")

    init {
        loadBlogListPaginated()
    }

    fun loadBlogListPaginated() {
        viewModelScope.launch {
            if (page == 1 || (page != 1 && canPaginate) && blogListState == BlogListState.IDLE)
                blogListState = if (page == 1) BlogListState.LOADING else BlogListState.PAGINATING
            val result = useCases.getBlogListUseCase(page)
            when (result) {
                is Resource.Success -> {

                    if (result.data != null) {
                        canPaginate = result.data.size == 5

                        if (page == 1) {
                            blogList.clear()
                            blogList.addAll(result.data)
                        }else{
                            blogList.addAll(result.data)
                        }
                        blogListState = BlogListState.IDLE
                        if (canPaginate) {
                            page++
                        } else {
                            blogListState =
                                if (page == 1) BlogListState.ERROR else BlogListState.PAGINATION_END
                        }

                    }

                }

                is Resource.Error -> {
                    blogListState = BlogListState.ERROR
                    error = result.message.toString()
                }

                else -> {
                    Log.d("HOMEVIEWMODEL", "something went wrong")
                }
            }

        }
    }

    override fun onCleared() {
        page = 1
        blogListState = BlogListState.IDLE
        canPaginate = false
        super.onCleared()
    }

}

enum class BlogListState {
    IDLE,
    LOADING,
    PAGINATING,
    ERROR,
    PAGINATION_END
}