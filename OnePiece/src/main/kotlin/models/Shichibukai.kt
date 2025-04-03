package org.example.models

import java.time.LocalDateTime

class Shichibukai(
    nombre: String,
    apodo: String,
    haki: Boolean,
    fruta: Boolean,
    vivo: Boolean,
    activo: Boolean,
    override val recompensa: String,
    override val tripulacion: String,
    override val rango: Rango,
    createAt: LocalDateTime,
    updateAt: LocalDateTime
) :Personaje(
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
}