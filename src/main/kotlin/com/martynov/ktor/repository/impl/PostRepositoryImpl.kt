package com.martynov.ktor.repository.impl

import com.martynov.ktor.models.Post
import com.martynov.ktor.repository.PostRepository
import org.hibernate.Session
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor() : PostRepository {
    override fun findAll(session: Session): List<Post> {
        return session.createQuery("select p from Post p", Post::class.java).resultList
    }

    override fun save(session: Session, value: Post): Boolean {
        session.save(value)
        return true
    }

    override fun findById(session: Session, id: Int): Post {
        return session.get(Post::class.java, id)
    }
}