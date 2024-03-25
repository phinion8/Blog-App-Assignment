package com.phinion.bloggy.domain.models


import com.google.gson.annotations.SerializedName

data class BlogItem(
    @SerializedName("aioseo_notices")
    val aioseoNotices: List<Any>,
    @SerializedName("author")
    val author: Int,
    @SerializedName("categories")
    val categories: List<Int>,
    @SerializedName("comment_status")
    val commentStatus: String,
    @SerializedName("content")
    val content: Content,
    @SerializedName("date")
    val date: String,
    @SerializedName("date_gmt")
    val dateGmt: String,
    @SerializedName("excerpt")
    val excerpt: Excerpt,
    @SerializedName("featured_media")
    val featuredMedia: Int,
    @SerializedName("format")
    val format: String,
    @SerializedName("guid")
    val guid: Guid,
    @SerializedName("id")
    val id: Int,
    @SerializedName("jetpack_featured_media_url")
    val jetpackFeaturedMediaUrl: String,
    @SerializedName("jetpack_likes_enabled")
    val jetpackLikesEnabled: Boolean,
    @SerializedName("jetpack_publicize_connections")
    val jetpackPublicizeConnections: List<Any>,
    @SerializedName("jetpack-related-posts")
    val jetpackRelatedPosts: List<Any>,
    @SerializedName("jetpack_sharing_enabled")
    val jetpackSharingEnabled: Boolean,
    @SerializedName("jetpack_shortlink")
    val jetpackShortlink: String,
    @SerializedName("link")
    val link: String,
    @SerializedName("_links")
    val links: Links,
    @SerializedName("meta")
    val meta: Meta,
    @SerializedName("modified")
    val modified: String,
    @SerializedName("modified_gmt")
    val modifiedGmt: String,
    @SerializedName("ping_status")
    val pingStatus: String,
    @SerializedName("slug")
    val slug: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("sticky")
    val sticky: Boolean,
    @SerializedName("tags")
    val tags: List<Int>,
    @SerializedName("template")
    val template: String,
    @SerializedName("title")
    val title: Title,
    @SerializedName("type")
    val type: String
)