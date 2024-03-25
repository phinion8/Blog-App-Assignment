package com.phinion.bloggy.data.remote

import com.phinion.bloggy.domain.models.BlogItem
import com.phinion.bloggy.domain.models.BlogResponse
import com.phinion.bloggy.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Query

interface BlogApi {

    @GET("posts?per_page=${Constants.PAGE_SIZE}")
    suspend fun getBlogList(
        @Query("page") offset: Int
    ): List<BlogItem>

}