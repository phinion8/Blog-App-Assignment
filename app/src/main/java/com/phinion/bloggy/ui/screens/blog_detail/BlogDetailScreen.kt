package com.phinion.bloggy.ui.screens.blog_detail

import android.graphics.Bitmap
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.phinion.bloggy.ui.screens.home.components.TopAppBar

@Composable
fun BlogDetailScreen(
    blogUrl: String
) {
    Column(modifier = Modifier.fillMaxSize()) {
        var backEnabled by remember { mutableStateOf(false) }
        var webView: WebView? = null
        AndroidView(
            modifier = Modifier.fillMaxSize(),
            factory = { context ->
                WebView(context).apply {
                    layoutParams = ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT
                    )
                    webViewClient = object : WebViewClient() {
                        override fun onPageStarted(view: WebView, url: String?, favicon: Bitmap?) {
                            backEnabled = view.canGoBack()
                        }
                    }
                    settings.javaScriptEnabled = true

                    loadUrl(blogUrl)
                    webView = this
                }
            }, update = {
                webView = it
            })

        BackHandler(enabled = backEnabled) {
            webView?.goBack()
        }
    }

}