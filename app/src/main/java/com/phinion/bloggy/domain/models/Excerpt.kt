package com.phinion.bloggy.domain.models


import com.google.gson.annotations.SerializedName

data class Excerpt(
    @SerializedName("protected")
    val `protected`: Boolean,
    @SerializedName("rendered")
    val rendered: String
)