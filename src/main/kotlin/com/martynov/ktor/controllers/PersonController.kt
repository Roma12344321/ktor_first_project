package com.martynov.ktor.controllers

import com.martynov.ktor.models.Person
import com.martynov.ktor.service.PersonService
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import javax.inject.Inject

class PersonController @Inject constructor(
    private val personService: PersonService,
    private val application: Application
) {
    fun init() {
        getAll()
        addOne()
    }

    private fun getAll() {
        application.routing {
            get("/person") {
                call.respond(personService.getAll())
            }
        }
    }

    private fun addOne() {
        application.routing {
            post("/person") {
                val receivedPerson = call.receive<Person>()
                personService.addOne(receivedPerson)
                call.respond(mapOf("success" to "success"))
            }
        }
    }
}