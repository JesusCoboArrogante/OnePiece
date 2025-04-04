package org.example.di

import org.lighthousegames.logging.logging

object Dependencias {
    val log = logging()

    init {
        log.debug { "iniciando las dependencias de la base de datos" }
    }


}