package com.martynov.ktor.repository

import com.martynov.ktor.models.Person
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.hibernate.Session
import org.hibernate.SessionFactory
import javax.inject.Inject

interface PersonRepository : Repository<Person, Int> {
}