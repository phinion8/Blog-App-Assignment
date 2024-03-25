package com.phinion.bloggy.domain.models


import com.google.gson.annotations.SerializedName

data class Content(
    @SerializedName("protected")
    val `protected`: Boolean,
    @SerializedName("rendered")
    val rendered: String
)