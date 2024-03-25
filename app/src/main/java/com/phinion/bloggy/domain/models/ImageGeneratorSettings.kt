package com.phinion.bloggy.domain.models


import com.google.gson.annotations.SerializedName

data class ImageGeneratorSettings(
    @SerializedName("enabled")
    val enabled: Boolean,
    @SerializedName("template")
    val template: String
)