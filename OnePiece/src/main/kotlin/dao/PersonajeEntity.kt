package org.example.dao

import org.example.models.Rango
import java.time.LocalDateTime

data class PersonajeEntity(
    val id: Int,
    val nombre: String,
    val apodo: String,
    val haki: Boolean ,
    val fruta: Boolean ,
    val vivo: Boolean ,
    val activo: Boolean ,
    val tipo: String,
    val createAt: LocalDateTime,
    val updateAt: LocalDateTime,
    val recompensa: Int?,
    val tripulacion: String?,
    val rango: Rango?

)
