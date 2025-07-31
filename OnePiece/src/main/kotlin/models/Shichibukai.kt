package org.example.models

import java.time.LocalDateTime

class Shichibukai(
    id: Long,
    nombre: String,
    apodo: String,
    haki: Boolean,
    fruta: Boolean,
    vivo: Boolean,
    activo: Boolean,
    override val recompensa: Int,
    override val tripulacion: String,
    override val rango: Rango,
    createAt: LocalDateTime,
    updateAt: LocalDateTime
) :Personaje(
    id,
    nombre,
    apodo,
    haki,
    fruta,
    vivo,
    activo,
    createAt,
    updateAt
), Pirata, Marina {

    override fun toString(): String {
        return "$nombre, $apodo, $haki, $fruta, $vivo, $activo, $recompensa, $tripulacion, $rango $createAt, $updateAt"
    }
    val tipo = "Shichibukai"
}