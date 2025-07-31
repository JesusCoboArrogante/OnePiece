package org.example.extension

import org.example.models.*
import java.time.LocalDateTime


fun Pirate.copy(
    newId: Long = this.id,
    newNombre: String = this.nombre,
    newApodo: String = this.apodo,
    newHaki: Boolean = this.haki,
    newFruta: Boolean = this.fruta,
    newVivo: Boolean = this.vivo,
    newActivo: Boolean = this.activo,
    newRecompensa: Int = this.recompensa,
    newTripulacion: String = this.tripulacion,
    time: LocalDateTime = LocalDateTime.now()
): Pirate {
    return Pirate(
        id = newId,
        nombre = newNombre,
        apodo = newApodo,
        haki = newHaki,
        fruta = newFruta,
        vivo = newVivo,
        activo = newActivo,
        recompensa = newRecompensa,
        tripulacion = newTripulacion,
        createAt = time,
        updateAt = time
        )
}

fun Marine.copy(
    newId: Long = this.id,
    newNombre: String = this.nombre,
    newApodo: String = this.apodo,
    newHaki: Boolean = this.haki,
    newFruta: Boolean = this.fruta,
    newVivo: Boolean = this.vivo,
    newActivo: Boolean = this.activo,
    newRango: Rango = this.rango,
    time: LocalDateTime = LocalDateTime.now()
):Marine {
    return Marine(
        id = newId,
        nombre = newNombre,
        apodo = newApodo,
        haki = newHaki,
        fruta = newFruta,
        vivo = newVivo,
        activo = newActivo,
        rango = newRango,
        createAt = time,
        updateAt = time
    )
}

fun Shichibukai.copy(
    newId: Long = this.id,
    newNombre: String = this.nombre,
    newApodo: String = this.apodo,
    newHaki: Boolean = this.haki,
    newFruta: Boolean = this.fruta,
    newVivo: Boolean = this.vivo,
    newActivo: Boolean = this.activo,
    newRecompensa: Int = this.recompensa,
    newTripulacion: String = this.tripulacion,
    newRango: Rango = this.rango,
    time: LocalDateTime = LocalDateTime.now()
):Shichibukai {
    return Shichibukai(
        id = newId,
        nombre = newNombre,
        apodo = newApodo,
        haki = newHaki,
        fruta = newFruta,
        vivo = newVivo,
        activo = newActivo,
        recompensa = newRecompensa,
        tripulacion = newTripulacion,
        rango = newRango,
        createAt = time,
        updateAt = time
    )
}