package com.martynov.ktor.repository.impl

import com.martynov.ktor.models.Person
import com.martynov.ktor.repository.PersonRepository
import org.hibernate.Session
import javax.inject.Inject

class PersonRepositoryImpl @Inject constructor() : PersonRepository {
    override fun findAll(session: Session): List<Person> {
        return session.createQuery("select p from Person p", Person::class.java).resultList
    }

    override fun save(session: Session, value: Person): Boolean {
        session.save(value)
        return true
    }

    override fun findById(session: Session, id: Int): Person {
        return session.get(Person::class.java, id)
    }
}