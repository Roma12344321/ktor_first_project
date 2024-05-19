package com.martynov.ktor.repository

import com.martynov.ktor.models.Post

interface PostRepository : Repository<Post,Int> {
}