package com.martynov.ktor.di

import io.ktor.server.application.*
import javax.inject.Inject

class MyApp(application: Application) {

    private val appComponent = DaggerAppComponent.factory().create(application)

    @Inject
    lateinit var initializer: ControllerInitializer

    init {
        appComponent.inject(this)
        initializer.init()
    }
}

