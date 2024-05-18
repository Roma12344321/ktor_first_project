package com.martynov.ktor.di

import com.martynov.ktor.controllers.PersonController
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ControllerInitializer @Inject constructor(
    private val personController: PersonController
) {
    fun init() {
        personController.init()
    }
}