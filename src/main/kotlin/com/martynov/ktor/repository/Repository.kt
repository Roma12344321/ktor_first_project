package com.martynov.ktor.repository

import org.hibernate.Session

interface Repository<T, I> {
    fun findAll(session: Session): List<T>
    fun save(session: Session, value: T): Boolean
    fun findById(session: Session, id: I): T?
}