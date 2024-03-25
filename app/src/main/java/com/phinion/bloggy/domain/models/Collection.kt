package com.phinion.bloggy.domain.models


import com.google.gson.annotations.SerializedName

data class Collection(
    @SerializedName("href")
    val href: String
)