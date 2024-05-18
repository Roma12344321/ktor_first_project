package com.martynov.ktor.di

import com.martynov.ktor.service.PersonServiceImpl
import com.martynov.ktor.service.interfaces.PersonService
import dagger.Binds
import dagger.Module

@Module
interface ServiceModule {
    @Binds
    fun bindPersonService(personServiceImpl: PersonServiceImpl) : PersonService
}