package com.martynov.ktor.service

import com.martynov.ktor.models.Person
import com.martynov.ktor.repository.PersonRepository
import com.martynov.ktor.service.interfaces.PersonService
import javax.inject.Inject

class PersonServiceImpl @Inject constructor(
    private val personRepository: PersonRepository
) : PersonService {

    override suspend fun getAll(): List<Person> {
        return personRepository.getAllPerson()
    }

    override suspend fun addOne(person: Person) {
        personRepository.addOne(person)
    }
}