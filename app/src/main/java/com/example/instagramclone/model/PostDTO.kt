package com.example.instagramclone.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class PostDTO (
    @SerializedName("user_sq_fk")
    @Expose
    public val user_id: String? = null,
    @SerializedName("id")
    @Expose
    public val user_profile_image: String? = null,
    @SerializedName("post_content")
    @Expose
    public val post_content: String? = null,
    @SerializedName("favoriteCount")
    @Expose
    public val favoriteCount: String? = null,
    @SerializedName("post_sq_pk")
    @Expose
    public val post_id: String? = null,
//    var imageList: MutableList<String> = ArrayList()
)