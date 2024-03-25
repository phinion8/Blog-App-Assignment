package com.phinion.bloggy.domain.models


import com.google.gson.annotations.SerializedName

data class WpAttachment(
    @SerializedName("href")
    val href: String
)