package com.example.musicalbumapplication

import kotlinx.serialization.Serializable

@Serializable
data class Album(
    val album: String,
    val artist: String,
    val price: String,
    val imageUrl: String
)