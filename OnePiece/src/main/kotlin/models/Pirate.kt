package org.example.models

import java.time.Instant
import java.time.LocalDateTime

class Pirate(
    id: Int,
    nombre: String,
    apodo: String,
    haki: Boolean,
    fruta: Boolean,
    vivo: Boolean,
    activo: Boolean,
    override val tripulacion: String,
    override val recompensa: String,
    createAt: LocalDateTime,
    updateAt: LocalDateTime
):Personaje(
    id,
    nombre,
    apodo,
    haki,
    fruta,
    vivo,
    activo,
    createAt,
    updateAt
),Pirata {
    override fun toString(): String {
        return "$nombre, $apodo, $haki, $fruta, $vivo, $activo, $recompensa, $tripulacion $createAt, $updateAt"
    }
}