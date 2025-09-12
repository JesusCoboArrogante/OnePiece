package org.example.models

import java.time.LocalDateTime

class Marine(
    id: Long,
    nombre: String,
    apodo: String,
    haki: Boolean,
    fruta: Boolean,
    vivo: Boolean,
    activo: Boolean,
    override val rango: Rango,
    tipo:String,
    createAt: LocalDateTime,
    updateAt: LocalDateTime
): Personaje(id, nombre, apodo, haki, fruta,
    vivo,
    activo,tipo, createAt, updateAt
),Marina {
    override fun toString(): String {
        return "$nombre, $apodo, $haki, $fruta, $vivo, $activo, $rango, $createAt, $updateAt"
    }

}