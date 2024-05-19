package com.martynov.ktor.di

import com.martynov.ktor.controllers.PersonController
import com.martynov.ktor.controllers.PostController
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ControllerInitializer @Inject constructor(
    private val personController: PersonController,
    private val postController: PostController
) {
    fun init() {
        personController.init()
        postController.init()
    }
}