package com.martynov.ktor.service.impl

import com.martynov.ktor.models.Post
import com.martynov.ktor.repository.PersonRepository
import com.martynov.ktor.repository.PostRepository
import com.martynov.ktor.service.PostService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.hibernate.SessionFactory
import javax.inject.Inject

class PostServiceImpl @Inject constructor(
    private val postRepository: PostRepository,
    private val sessionFactory: SessionFactory,
    private val personRepository: PersonRepository
) : PostService {
    override suspend fun getALl(): List<Post> {
        return withContext(Dispatchers.IO) {
            val session = sessionFactory.openSession()
            try {
                session.beginTransaction()

                val post = postRepository.findAll(session)

                session.transaction.commit()
                return@withContext post
            } catch (e: Exception) {
                session.transaction.rollback()
                throw RuntimeException(e)
            } finally {
                session.close()
            }
        }
    }

    override suspend fun add(post: Post, personId: Int) {
        withContext(Dispatchers.IO) {
            val session = sessionFactory.openSession()
            try {
                session.beginTransaction()

                val person = personRepository.findById(session, personId)
                post.person = person
                postRepository.save(session, post)

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