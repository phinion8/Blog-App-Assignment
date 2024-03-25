package com.phinion.bloggy.utils

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

object AppUtils {
    suspend fun encodeUrl(url: String): String{
        val encodedBlogUrl = withContext(Dispatchers.IO) {
            URLEncoder.encode(url, StandardCharsets.UTF_8.toString())
        }
        return encodedBlogUrl
    }
}