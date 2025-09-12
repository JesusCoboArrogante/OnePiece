package org.example.database

import org.example.config.Config
import org.jdbi.v3.core.Jdbi
import org.jdbi.v3.core.kotlin.KotlinPlugin

import org.jdbi.v3.sqlobject.SqlObjectPlugin
import org.lighthousegames.logging.logging
import java.io.File

class JdbiManager private constructor(){
    private val log = logging()

    private val jdbi = Jdbi.create(Config.databaseUrl)

    companion object{
        //Instancia unica
        val instancia: Jdbi by lazy {
            JdbiManager().jdbi
        }
    }
    fun ejecutarSqlScript(scriptFilePath: String){
        log.debug { "ejecutanto el script $scriptFilePath" }
        val script = File(scriptFilePath).readText()
        jdbi.useHandle<Exception>{ handle ->
            handle.createScript(script).execute()

        }
    }

    fun ejecutarScripCreacionTabla(tables: String) {
        log.debug { "ejecutando el scrip de creacion de la tabla" }
        val script = File(tables).readText()
            jdbi.useHandle<Exception>{ handle ->
                handle.createScript(script).execute()
            }

    }

    init {
        log.debug { "iniciando el jdbi" }

        jdbi.installPlugin(KotlinPlugin())
        jdbi.installPlugin(SqlObjectPlugin())

        if (Config.databaseInitTables){
            log.debug { "creando tablas" }
            ejecutarScripCreacionTabla("tables.sql")
        }
    }




}