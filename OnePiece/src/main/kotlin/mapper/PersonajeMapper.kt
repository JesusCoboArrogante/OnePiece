package org.example.mapper

import org.example.dao.PersonajeEntity
import org.example.dto.PersonajeDTO
import org.example.models.*


fun PersonajeEntity.toModel():Personaje {
        return if (this.tipo == "Pirate"){
            Pirate(
                id = this.id,
                nombre = this.nombre,
                apodo = this.apodo,
                haki = this.haki,
                fruta = this.fruta,
                vivo = this.vivo,
                activo = this.activo,
                createAt = this.createAt,
                updateAt = this.updateAt,
                recompensa = this.recompensa!!,
                tripulacion = this.tripulacion!!
            )
        } else if (this.tipo == "Shichibukai"){
            Shichibukai(
                id = this.id,
                nombre = this.nombre,
                apodo = this.apodo,
                haki = this.haki,
                fruta = this.fruta,
                vivo = this.vivo,
                activo = this.activo,
                createAt = this.createAt,
                updateAt = this.updateAt,
                recompensa = this.recompensa!!,
                tripulacion = this.tripulacion!!,
                rango = this.rango!!
            )
        }else{
            Marine(
                id = this.id,
                nombre = this.nombre,
                apodo = this.apodo,
                haki = this.haki,
                fruta = this.fruta,
                vivo = this.vivo,
                activo = this.activo,
                createAt = this.createAt,
                updateAt = this.updateAt,
                rango = this.rango!!
            )
        }
}

fun Pirate.toEntity(): PersonajeEntity {
    return PersonajeEntity(
        id = id,
        nombre = nombre,
        apodo = apodo,
        haki = haki,
        fruta = fruta,
        vivo = vivo,
        activo = activo,
        tipo = tipo,
        createAt = createAt,
        updateAt = updateAt,
        recompensa = recompensa,
        tripulacion = tripulacion,
        rango = null
    )
}

    fun Marine.toEntity(): PersonajeEntity{
        return PersonajeEntity(
            id = id,
            nombre = nombre,
            apodo = apodo,
            haki = haki,
            fruta = fruta,
            vivo = vivo,
            activo = activo,
            tipo = tipo,
            createAt = createAt,
            updateAt = updateAt,
            recompensa = null,
            tripulacion = null,
            rango = rango
        )
    }

    fun Shichibukai.toEntity(): PersonajeEntity{
        return PersonajeEntity(
            id = id,
            nombre = nombre,
            apodo = apodo,
            haki = haki,
            fruta = fruta,
            vivo = vivo,
            activo = activo,
            tipo = tipo,
            createAt = createAt,
            updateAt = updateAt,
            recompensa = recompensa,
            tripulacion = tripulacion,
            rango = rango
        )
    }

    fun PersonajeDTO.toModel():Personaje{
        return if (this.tipo == "Pirate"){
            Pirate(
                id = id,
                nombre = nombre,
                apodo = apodo,
                haki = haki,
                fruta = fruta,
                vivo = vivo,
                activo = activo,
                createAt = createAt,
                updateAt = updateAt,
                recompensa = recompensa!!,
                tripulacion = tripulacion!!
            )
        }else if (this.tipo == "Marine"){
            return Marine(id = id,
                nombre = nombre,
                apodo = apodo,
                haki = haki,
                fruta = fruta,
                vivo = vivo,
                activo = activo,
                createAt = createAt,
                updateAt = updateAt,
                rango = rango!!
            )

        } else{
           return Shichibukai(id = id,
                nombre = nombre,
                apodo = apodo,
                haki = haki,
                fruta = fruta,
                vivo = vivo,
                activo = activo,
                createAt = createAt,
                updateAt = updateAt,
                recompensa = recompensa!!,
                tripulacion = tripulacion!!,
                rango = rango!!
            )

        }
    }

fun Pirate.toDto(): PersonajeDTO{
    return PersonajeDTO(
        id = id,
        nombre = nombre,
        apodo = apodo,
        haki = haki,
        fruta = fruta,
        vivo = vivo,
        activo = activo,
        tipo = tipo,
        createAt = createAt,
        updateAt = updateAt,
        recompensa = recompensa,
        tripulacion = tripulacion,
        rango = null
    )
}

fun Marine.toDto():PersonajeDTO{
    return PersonajeDTO(
        id = id,
        nombre = nombre,
        apodo = apodo,
        haki = haki,
        fruta = fruta,
        vivo = vivo,
        activo = activo,
        tipo = tipo,
        createAt = createAt,
        updateAt = updateAt,
        recompensa = null,
        tripulacion = null,
        rango = rango
    )
}

fun Shichibukai.toDto():PersonajeDTO{
    return PersonajeDTO(
        id = id,
        nombre = nombre,
        apodo = apodo,
        haki = haki,
        fruta = fruta,
        vivo = vivo,
        activo = activo,
        tipo = tipo,
        createAt = createAt,
        updateAt = updateAt,
        recompensa = recompensa,
        tripulacion = tripulacion,
        rango = rango
    )
}



