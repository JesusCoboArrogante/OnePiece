package org.example.models

import java.time.LocalDateTime

class Marine(
    nombre: String,
    apodo: String,
    haki: Boolean,
    fruta: Boolean,
    vivo: Boolean,
    activo: Boolean,
    override val rango: Rango,
    createAt: LocalDateTime,
    updateAt: LocalDateTime
): Personaje(nombre, apodo, haki, fruta,
    vivo,
    activo, createAt, updateAt
),Marina {
    override fun toString(): String {
        return "$nombre, $apodo, $haki, $fruta, $vivo, $activo, $rango, $createAt, $updateAt"
    }
}