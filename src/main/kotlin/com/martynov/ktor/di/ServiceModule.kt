package com.martynov.ktor.di

import com.martynov.ktor.service.impl.PersonServiceImpl
import com.martynov.ktor.service.impl.PostServiceImpl
import com.martynov.ktor.service.PersonService
import com.martynov.ktor.service.PostService
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