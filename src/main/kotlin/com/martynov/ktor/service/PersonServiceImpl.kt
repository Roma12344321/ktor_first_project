package com.martynov.ktor.service

import com.martynov.ktor.models.Person
import com.martynov.ktor.repository.PersonRepository
import com.martynov.ktor.service.interfaces.PersonService
import javax.inject.Inject

class PersonServiceImpl @Inject constructor(
    private val personRepository: PersonRepository
) : PersonService {

    private var id = 1;

    private val list = mutableListOf(
        Person(id++, "Roma"), Person(id++, "Bill"), Person(id++, "Bob")
    )

    override fun getAll(): List<Person> {
        return list
    }

    override fun addOne(person: Person) {
        person.id = id++;
        list.add(person)
    }
}