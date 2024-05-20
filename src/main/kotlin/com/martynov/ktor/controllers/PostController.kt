package com.martynov.ktor.controllers

import com.martynov.ktor.models.Post
import com.martynov.ktor.service.PostService
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import javax.inject.Inject

class PostController @Inject constructor(
    private val application: Application,
    private val postService: PostService
) {
    fun init() {
        getAll()
        add()
    }

    private fun getAll() {
        application.routing {
            get("/post") {
                call.respond(postService.getALl())
            }
        }
    }

    private fun add() {
        application.routing {
            post("/post") {
                val personId = call.request.queryParameters["person_id"]?.toInt() ?: return@post
                val post = call.receive(Post::class)
                postService.add(post, personId)
                call.respond(mapOf("success" to "success"))
            }
        }
    }
}