package com.phinion.bloggy.ui.screens.home

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.phinion.bloggy.ui.components.isScrollingUp
import com.phinion.bloggy.ui.screens.home.components.BlogItemLayout
import com.phinion.bloggy.ui.screens.home.components.BlogItemLoading
import com.phinion.bloggy.ui.screens.home.components.TopAppBar
import com.phinion.bloggy.ui.screens.home.viewmodel.BlogListState
import com.phinion.bloggy.ui.screens.home.viewmodel.HomeViewModel
import com.phinion.bloggy.utils.AppUtils
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel(),
    onBlogItemClick: (blogUrl: String) -> Unit
) {

    val lazyColumnState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    val shouldStartPaginate = remember {
        derivedStateOf {
            viewModel.canPaginate && (lazyColumnState.layoutInfo.visibleItemsInfo.lastOrNull()?.index
                ?: -9) >= (lazyColumnState.layoutInfo.totalItemsCount - 3)
        }
    }
    val blogList = viewModel.blogList

    Log.d("HOMEISSUE", "pagination ${shouldStartPaginate.value}")

    LaunchedEffect(key1 = shouldStartPaginate.value) {
        if (shouldStartPaginate.value && viewModel.blogListState == BlogListState.IDLE) {
            viewModel.loadBlogListPaginated()
        }
    }

    var topBarVisibility = lazyColumnState.isScrollingUp()



    Scaffold(
        topBar = {
            AnimatedVisibility(
                visible = topBarVisibility,
                exit = shrinkVertically(),
                enter = expandVertically()
            ) {
                TopAppBar()
            }

        },
        content = { paddingValues ->

            Column(
                modifier = Modifier.padding(
                    top = paddingValues.calculateTopPadding(),
                    bottom = paddingValues.calculateBottomPadding() + 100.dp,
                    start = 8.dp,
                    end = 8.dp
                )
            ) {

                LazyColumn(
                    state = lazyColumnState,
                    contentPadding = PaddingValues(vertical = 8.dp, horizontal = 8.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    items(blogList) {
                        BlogItemLayout(blogItem = it, onBlogItemClick = {url->
                            coroutineScope.launch {
                               val encodedUrl = AppUtils.encodeUrl(url)
                                onBlogItemClick(encodedUrl)
                            }
                        })
                    }

                    item {
                        when (viewModel.blogListState) {
                            BlogListState.LOADING -> {
                                Column(
                                    verticalArrangement = Arrangement.spacedBy(16.dp)
                                ) {
                                    repeat(5) {
                                        BlogItemLoading()
                                    }
                                }
                            }

                            BlogListState.PAGINATING -> {
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(all = 16.dp),
                                    contentAlignment = Alignment.Center
                                ) {
                                    CircularProgressIndicator()
                                }

                            }

                            else -> {

                            }
                        }
                    }

                }
            }

        }
    )
}
