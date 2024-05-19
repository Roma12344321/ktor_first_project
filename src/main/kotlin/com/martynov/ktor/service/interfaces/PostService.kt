package com.martynov.ktor.service.interfaces

import com.martynov.ktor.models.Post

interface PostService {
    suspend fun getALl(): List<Post>
    suspend fun add(post: Post, personId: Int)
}