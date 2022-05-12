package com.example.youtube_clone.models2

data class Snippet(
    val channelId: String,
    val channelTitle: String,
    val description: String,
    val liveBroadcastContent: String,
    val publishTime: String,
    val publishedAt: String,
    val thumbnails: Thumbnails,
    val title: String
)