package org.example.mapper

import org.example.dao.PersonajeEntity
import org.example.dto.PersonajeDTO
import org.example.dto.PersonajeXmlDto
import org.example.models.*
import java.time.LocalDate
import java.time.LocalDateTime


fun PersonajeEntity.toModel():Personaje {
        return if (this.tipo == "Pirate"){
            Pirate(
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
                recompensa = recompensa!!,
                tripulacion = tripulacion!!
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
                tipo = this.tipo,
                createAt = this.createAt,
                updateAt = this.updateAt,
                recompensa = this.recompensa!!,
                tripulacion = this.tripulacion!!,
                rango = Rango.valueOf(rango!!)
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
                tipo = this.tipo,
                createAt = this.createAt,
                updateAt = this.updateAt,
                rango = Rango.valueOf(rango!!)
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
        rango = null.toString()
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
            rango = rango.toString()
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
            rango = rango.toString()
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
                tipo = tipo,
                createAt = LocalDateTime.parse(createAt),
                updateAt = LocalDateTime.parse(createAt),
                recompensa = recompensa!!,
                tripulacion = tripulacion!!
            )
        }else if (this.tipo == "Marine"){
            return Marine(
                id = id,
                nombre = nombre,
                apodo = apodo,
                haki = haki,
                fruta = fruta,
                vivo = vivo,
                activo = activo,
                tipo = tipo,
                createAt = LocalDateTime.parse(createAt),
                updateAt = LocalDateTime.parse(createAt),
                rango = Rango.valueOf(rango!!)
            )

        } else{
           return Shichibukai(
               id = id,
               nombre = nombre,
               apodo = apodo,
               haki = haki,
               fruta = fruta,
               vivo = vivo,
               activo = activo,
               tipo = tipo,
               createAt = LocalDateTime.parse(createAt),
               updateAt = LocalDateTime.parse(createAt),
               recompensa = recompensa!!,
               tripulacion = tripulacion!!,
               rango = Rango.valueOf(rango!!)

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
        createAt = createAt.toString(),
        updateAt = updateAt.toString(),
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
        createAt = createAt.toString(),
        updateAt = updateAt.toString(),
        recompensa = null,
        tripulacion = null,
        rango = rango.toString()
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
        createAt = createAt.toString(),
        updateAt = updateAt.toString(),
        recompensa = recompensa,
        tripulacion = tripulacion,
        rango = rango.toString()
    )

}

fun PersonajeXmlDto.toModel():Personaje{
    return if (this.tipo == "Pirate"){
        Pirate(
            id = id,
            nombre = nombre,
            apodo = apodo,
            haki = haki,
            fruta = fruta,
            vivo = vivo,
            activo = activo,
            tipo = tipo,
            createAt = LocalDateTime.parse(createAt),
            updateAt = LocalDateTime.parse(createAt),
            recompensa = recompensa!!,
            tripulacion = tripulacion!!
        )
    }else if (this.tipo == "Marine"){
        return Marine(
            id = id,
            nombre = nombre,
            apodo = apodo,
            haki = haki,
            fruta = fruta,
            vivo = vivo,
            activo = activo,
            tipo = tipo,
            createAt = LocalDateTime.parse(createAt),
            updateAt = LocalDateTime.parse(createAt),
            rango = Rango.valueOf(rango!!)
        )

    } else{
        return Shichibukai(
            id = id,
            nombre = nombre,
            apodo = apodo,
            haki = haki,
            fruta = fruta,
            vivo = vivo,
            activo = activo,
            tipo = tipo,
            createAt = LocalDateTime.parse(createAt),
            updateAt = LocalDateTime.parse(createAt),
            recompensa = recompensa!!,
            tripulacion = tripulacion!!,
            rango = Rango.valueOf(rango!!)

        )

    }


}

fun Pirate.toXmlDto(): PersonajeXmlDto{
    return PersonajeXmlDto(
        id = id,
        nombre = nombre,
        apodo = apodo,
        haki = haki,
        fruta = fruta,
        vivo = vivo,
        activo = activo,
        tipo = tipo,
        createAt = createAt.toString(),
        updateAt = updateAt.toString(),
        tripulacion = tripulacion,
        recompensa = recompensa,
        rango = ""
    )
}

fun Marine.toXmlDto(): PersonajeXmlDto{
    return PersonajeXmlDto(
        id = id,
        nombre = nombre,
        apodo = apodo,
        haki = haki,
        fruta = fruta,
        vivo = vivo,
        activo = activo,
        tipo = tipo,
        createAt = createAt.toString(),
        updateAt = updateAt.toString(),
        tripulacion = null,
        recompensa = null,
        rango = rango.toString()
    )
}
fun Shichibukai.toXmlDto(): PersonajeXmlDto{
    return PersonajeXmlDto(
        id = id,
        nombre = nombre,
        apodo = apodo,
        haki = haki,
        fruta = fruta,
        vivo = vivo,
        activo = activo,
        tipo = tipo,
        createAt = createAt.toString(),
        updateAt = updateAt.toString(),
        tripulacion = tripulacion,
        recompensa = recompensa,
        rango = rango.toString()
    )
}




