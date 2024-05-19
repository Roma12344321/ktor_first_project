package com.martynov.ktor.models

import javax.persistence.*

@Entity
@Table(name = "person")
data class Person(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Int? = 0,
    @Column(name = "name")
    var name: String?,
//    @OneToMany(mappedBy = "person")
//    var postList: List<Post>?
) {
    constructor() : this(0, null) {}
}