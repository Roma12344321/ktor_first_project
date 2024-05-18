package com.martynov.ktor.repository

import com.martynov.ktor.models.Person
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.hibernate.SessionFactory
import javax.inject.Inject

class PersonRepository @Inject constructor(
    private val sessionFactory: SessionFactory
) {
    suspend fun getAllPerson() : List<Person> {
        return withContext(Dispatchers.IO) {
            val session = sessionFactory.openSession()
            session.beginTransaction()
            val people = session.createQuery("select p from Person p", Person::class.java).resultList
            session.transaction.commit()
            session.close()
            people.toList()
        }
    }
    suspend fun addOne(person: Person) : Boolean{
        return withContext(Dispatchers.IO) {
            val session = sessionFactory.openSession()
            session.beginTransaction()
            session.save(person)
            session.transaction.commit()
            session.close()
            true
        }
    }
}