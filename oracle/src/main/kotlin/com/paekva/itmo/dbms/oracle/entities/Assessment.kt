package com.paekva.itmo.dbms.oracle.entities

import java.time.Instant
import javax.persistence.*

@Entity
@Table(name = "assessment")
data class Assessment(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    val id: Int? = null,

    @Column(nullable = false)
    val name: String,

    @Column(nullable = false)
    val mark: Int,

    @Column(nullable = false)
    val markLetter: String,

    @Column(nullable = false)
    val achievedAt: Instant,

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "achieved_by", nullable = false)
    val achievedBy: Person,

    @Column(nullable = false)
    val disciplineName: String
)