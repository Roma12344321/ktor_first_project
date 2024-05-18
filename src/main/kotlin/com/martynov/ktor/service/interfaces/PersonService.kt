package com.martynov.ktor.service.interfaces

import com.martynov.ktor.models.Person

interface PersonService {
    suspend fun getAll() : List<Person>
    suspend fun addOne(person: Person)
}