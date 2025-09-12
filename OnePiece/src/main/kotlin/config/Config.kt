package org.example.config

import org.lighthousegames.logging.logging
import java.util.Locale
import java.util.Properties

object Config {

    private val log = logging()

    //valores por defecto de la base de datos
    var databaseUrl: String = "jdbc:h2:mem:personajesOnePiece"
        private set
    var databaseInitTables: Boolean = false
        private set
    var databaseInitData: Boolean = false
        private set
    var storageData: String = "data"
        private set

    var locale: String = Locale.getDefault().language

    init {
       try {
           log.debug { "Cargando configuracion"}
               val properties = Properties()
               properties.load(ClassLoader.getSystemResourceAsStream("config.properties"))
               databaseUrl = properties.getProperty("database.url", this.databaseUrl)
               databaseInitTables =
                   properties.getProperty("database.init.tables", this.databaseInitTables.toString()).toBoolean()
               databaseInitData =
                   properties.getProperty("database.init.data", this.databaseInitData.toString()).toBoolean()
               storageData = properties.getProperty("locale", this.locale)
               log.debug { "base de datos cargada" }

    }catch (e:Exception){
        log.error { "error cargando la base de datos: ${e.message}" }
           log.error { "usando valores por defecto" }
    }
    }

}