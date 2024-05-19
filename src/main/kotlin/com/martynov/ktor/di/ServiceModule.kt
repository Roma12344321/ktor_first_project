package com.martynov.ktor.di

import com.martynov.ktor.service.PersonServiceImpl
import com.martynov.ktor.service.PostServiceImpl
import com.martynov.ktor.service.interfaces.PersonService
import com.martynov.ktor.service.interfaces.PostService
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface ServiceModule {
    @Binds
    @Singleton
    fun bindPersonService(personServiceImpl: PersonServiceImpl) : PersonService

    @Binds
    @Singleton
    fun bindPostService(postServiceImpl: PostServiceImpl) : PostService
}