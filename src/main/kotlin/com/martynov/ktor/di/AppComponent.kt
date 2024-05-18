package com.martynov.ktor.di

import dagger.BindsInstance
import dagger.Component
import io.ktor.server.application.*
import javax.inject.Singleton

@Singleton
@Component(modules = [ServiceModule::class,HibernateModule::class])
interface AppComponent {

    fun inject(myApp: MyApp)

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance application: Application,
        ): AppComponent
    }
}