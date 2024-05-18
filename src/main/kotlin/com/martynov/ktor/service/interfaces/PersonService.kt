package com.martynov.ktor.service.interfaces

import com.martynov.ktor.models.Person

interface PersonService {
    fun getAll() : List<Person>
    fun addOne(person: Person)
}