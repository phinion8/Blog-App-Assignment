package com.phinion.bloggy.domain.models


import com.google.gson.annotations.SerializedName

data class Meta(
    @SerializedName("footnotes")
    val footnotes: String,
    @SerializedName("_jetpack_dont_email_post_to_subs")
    val jetpackDontEmailPostToSubs: Boolean,
    @SerializedName("_jetpack_memberships_contains_paid_content")
    val jetpackMembershipsContainsPaidContent: Boolean,
    @SerializedName("_jetpack_memberships_contains_paywalled_content")
    val jetpackMembershipsContainsPaywalledContent: Boolean,
    @SerializedName("_jetpack_newsletter_access")
    val jetpackNewsletterAccess: String,
    @SerializedName("_jetpack_newsletter_tier_id")
    val jetpackNewsletterTierId: Int,
    @SerializedName("jetpack_post_was_ever_published")
    val jetpackPostWasEverPublished: Boolean,
    @SerializedName("jetpack_publicize_feature_enabled")
    val jetpackPublicizeFeatureEnabled: Boolean,
    @SerializedName("jetpack_publicize_message")
    val jetpackPublicizeMessage: String,
    @SerializedName("jetpack_social_options")
    val jetpackSocialOptions: JetpackSocialOptions,
    @SerializedName("jetpack_social_post_already_shared")
    val jetpackSocialPostAlreadyShared: Boolean
)