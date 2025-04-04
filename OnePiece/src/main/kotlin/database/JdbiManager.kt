package org.example.database

import org.jdbi.v3.core.Jdbi
import org.lighthousegames.logging.logging

class JdbiManager private constructor(){
    private val log = logging()

    companion object{
        //Instancia unica
        val instancia: Jdbi by lazy {
            JdbiManager.jdbi
        }
    }

    private val jdbi = Jdbi.create(Config.databaseUrl)
}