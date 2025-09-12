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
    tipo: String,
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
    tipo,
    createAt,
    updateAt
), Pirata, Marina {

    override fun toString(): String {
        return "$nombre, $apodo, $haki, $fruta, $vivo, $activo, $recompensa, $tripulacion, $rango $createAt, $updateAt"
    }

}