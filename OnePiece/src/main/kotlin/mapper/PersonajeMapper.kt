package org.example.mapper

import org.example.dao.PersonajeEntity
import org.example.models.Marine
import org.example.models.Personaje
import org.example.models.Pirate
import org.example.models.Shichibukai


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


