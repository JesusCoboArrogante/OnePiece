package org.example.models

import java.time.LocalDateTime

class Marine(
    id: Int,
    nombre: String,
    apodo: String,
    haki: Boolean,
    fruta: Boolean,
    vivo: Boolean,
    activo: Boolean,
    override val rango: Rango,
    createAt: LocalDateTime,
    updateAt: LocalDateTime
): Personaje(id, nombre, apodo, haki, fruta,
    vivo,
    activo, createAt, updateAt
),Marina {
    override fun toString(): String {
        return "$nombre, $apodo, $haki, $fruta, $vivo, $activo, $rango, $createAt, $updateAt"
    }
    val tipo = "Marine"
}