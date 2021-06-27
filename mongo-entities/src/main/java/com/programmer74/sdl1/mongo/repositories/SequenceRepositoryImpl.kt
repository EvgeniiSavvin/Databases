package com.programmer74.sdl1.mongo.repositories

import com.programmer74.sdl1.mongo.entities.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.querydsl.QuerydslPredicateExecutor
import org.springframework.stereotype.Repository
import java.util.*


@Repository
class SequenceRepositoryImpl(
        @Autowired
        var mongoOperation: MongoOperations
): SequenceRepository {

    override fun getNextSequenceId(key: String): Long {
        SEQ.merge(key, 1, Long::plus)
        return SEQ[key]!!
    }

    companion object {
        private val SEQ: MutableMap<String, Long> = hashMapOf(Pair("person", 0L), Pair("dorm", 0L), Pair("group", 0L))
    }

}
