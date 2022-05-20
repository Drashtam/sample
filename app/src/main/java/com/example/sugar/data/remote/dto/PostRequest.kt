package com.example.sugar.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class PostRequest(
    val body : String,
    val title : String,
    val userId : Int
)
