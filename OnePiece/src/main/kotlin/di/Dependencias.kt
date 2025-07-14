package org.example.di

import org.example.database.JdbiManager
import org.jdbi.v3.core.Jdbi
import org.lighthousegames.logging.logging

object Dependencias {
    val log = logging()

    init {
        log.debug { "iniciando las dependencias de la base de datos" }
    }

    fun obtenerGestorBaseDatos():Jdbi{
        log.debug { "proporcionando JDBI" }
        return JdbiManager.instancia
    }


}