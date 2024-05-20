package com.martynov.ktor.service.impl

import com.martynov.ktor.models.Person
import com.martynov.ktor.repository.PersonRepository
import com.martynov.ktor.service.PersonService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.hibernate.SessionFactory
import javax.inject.Inject

class PersonServiceImpl @Inject constructor(
    private val personRepository: PersonRepository,
    private val sessionFactory: SessionFactory,
) : PersonService {

    override suspend fun getAll(): List<Person> {
        return withContext(Dispatchers.IO) {
            val session = sessionFactory.openSession()
            try {
                session.beginTransaction()
                // there is logic
                val people = personRepository.findAll(session)

                session.transaction.commit()
                return@withContext people
            } catch (e: Exception) {
                session.transaction.rollback()
                throw RuntimeException(e)
            } finally {
                session.close()
            }
        }
    }

    override suspend fun addOne(person: Person) {
        withContext(Dispatchers.IO) {
            val session = sessionFactory.openSession()
            try {
                session.beginTransaction()
                // there is logic
                personRepository.save(session, person)

                session.transaction.commit()
            } catch (e: Exception) {
                session.transaction.rollback()
                throw RuntimeException(e)
            } finally {
                session.close()
            }
        }
    }
}