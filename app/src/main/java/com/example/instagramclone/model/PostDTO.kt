package com.example.instagramclone.model

data class PostDTO (
    var user_id: String? = null,
    var user_profile_image: String? = null,
    var post_content: String? = null,
    var favoriteCount: String? = null,
    var imageList: MutableList<String> = ArrayList()
)