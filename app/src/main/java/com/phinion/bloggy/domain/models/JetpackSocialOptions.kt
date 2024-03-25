package com.phinion.bloggy.domain.models


import com.google.gson.annotations.SerializedName

data class JetpackSocialOptions(
    @SerializedName("image_generator_settings")
    val imageGeneratorSettings: ImageGeneratorSettings
)