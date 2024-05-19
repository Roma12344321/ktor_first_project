package com.martynov.ktor.di

import com.martynov.ktor.repository.PersonRepository
import com.martynov.ktor.repository.PostRepository
import com.martynov.ktor.repository.impl.PersonRepositoryImpl
import com.martynov.ktor.repository.impl.PostRepositoryImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface RepositoryModule {
    @Binds
    @Singleton
    fun bindPersonRepository(impl: PersonRepositoryImpl): PersonRepository

    @Binds
    @Singleton
    fun bindPostRepository(impl: PostRepositoryImpl): PostRepository
}