package org.example.dto
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.example.models.Rango

import java.io.Serial
import java.time.LocalDateTime

@Serializable
@SerialName("personaje")
data class PersonajeDTO(

    @SerialName("id")
    val id: Int,

    @SerialName("nombre")
    val nombre: String,

    @SerialName("apodo")
    val apodo: String,

    @SerialName("haki")
    val haki: Boolean,

    @SerialName("fruta")
    val fruta: Boolean,

    @SerialName("vivo")
    val vivo: Boolean,

    @SerialName("activo")
    val activo: Boolean,

    @SerialName("tipo")
    val tipo: String,

    @SerialName("createAt")
    val createAt: LocalDateTime,

    @SerialName("updateAt")
    val updateAt: LocalDateTime,

    @SerialName("recompensas")
    val recompensa: Int?,

    @SerialName("tripulacion")
    val tripulacion: String?,

    @SerialName("rango")
    val rango: Rango?
)
