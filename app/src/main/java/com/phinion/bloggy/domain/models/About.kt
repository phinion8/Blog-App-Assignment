package com.phinion.bloggy.domain.models


import com.google.gson.annotations.SerializedName

data class About(
    @SerializedName("href")
    val href: String
)