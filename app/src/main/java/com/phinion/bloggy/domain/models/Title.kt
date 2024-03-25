package com.phinion.bloggy.domain.models


import com.google.gson.annotations.SerializedName

data class Title(
    @SerializedName("rendered")
    val rendered: String
)