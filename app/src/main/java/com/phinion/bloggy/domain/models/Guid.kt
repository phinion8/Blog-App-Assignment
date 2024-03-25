package com.phinion.bloggy.domain.models


import com.google.gson.annotations.SerializedName

data class Guid(
    @SerializedName("rendered")
    val rendered: String
)