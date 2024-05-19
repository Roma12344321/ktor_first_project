package com.martynov.ktor.models

import javax.persistence.*

@Entity
@Table(name = "post")
data class Post(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Int? = 0,

    @Column(name = "title")
    val title: String?,

    @Column(name = "text")
    val text: String?,

    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    var person: Person?
) {
    constructor() : this(0,null,null,null)
}