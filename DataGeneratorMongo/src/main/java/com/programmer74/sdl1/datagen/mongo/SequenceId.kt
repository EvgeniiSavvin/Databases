package com.programmer74.sdl1.datagen.mongo

import org.springframework.data.mongodb.core.mapping.Document
import javax.persistence.Id

@Document(collection = "sequence")
open class SequenceId (
        @Id
        val id: String,

        val seq: Long
)