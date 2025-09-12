package org.example.storage

import com.github.michaelbull.result.Err
import com.github.michaelbull.result.Ok
import com.github.michaelbull.result.Result
import org.example.dto.PersonajeDTO
import org.example.error.PersonajeError
import org.example.mapper.toDto
import org.example.mapper.toModel
import org.example.models.Marine
import org.example.models.Personaje
import org.example.models.Pirate
import org.example.models.Shichibukai
import java.io.File

class StorageCsv:Storage {
    override fun leer(archivo: File): Result<List<Personaje>, PersonajeError> {
        if (!archivo.exists()|| !archivo.isFile || !archivo.canRead()) return Err(PersonajeError.StorageError("el archivo no se puede leer, no es un archivo  o no se puede leer"))
        return Ok(archivo.readLines()
            .drop(1)
            .map { it.split(",") }
            .map {
                PersonajeDTO(
                    id = it[0].toLong(),
                    nombre = it[1],
                    apodo = it[2],
                    haki = it[3].toBoolean(),
                    fruta = it[4].toBoolean(),
                    vivo = it[5].toBoolean(),
                    activo  = it[6].toBoolean(),
                    tipo = it[7],
                    createAt = it[8],
                    updateAt = it[9],
                    tripulacion = it[10],
                    recompensa = it [11].toInt(),
                    rango = it[12],
                ).toModel()
            }
        )
    }

    override fun escribir(fraccion: List<Personaje>, archivo: File): Result<Unit, PersonajeError> {
        if (!archivo.parentFile.exists() || !archivo.parentFile.isDirectory){
            return Err(PersonajeError.StorageError("el directorio no existe"))
        }
        archivo.writeText("id, nombre, apodo, haki, fruta, vivo, activo, tipo, createAt, updateAt, tripulacion, recompensa, rango")
        fraccion.map {
            if (it is Pirate){
                it.toDto()
                archivo.appendText("${it.id}, ${it.nombre},${it.apodo}, ${it.haki}, ${it.fruta}, ${it.vivo}, ${it.activo}, ${it.tipo}, ${it.createAt}, ${it.updateAt}, ${it.tripulacion}, ${it.recompensa},")
            }
            if (it is Marine){
                it.toDto()
                archivo.appendText("${it.id}, ${it.nombre},${it.apodo}, ${it.haki}, ${it.fruta}, ${it.vivo}, ${it.activo}, ${it.tipo}, ${it.createAt}, ${it.updateAt},,, ${it.rango}")
            }
            if (it is Shichibukai){
                it.toDto()
                archivo.appendText("${it.id}, ${it.nombre},${it.apodo}, ${it.haki}, ${it.fruta}, ${it.vivo}, ${it.activo}, ${it.tipo}, ${it.createAt}, ${it.updateAt}, ${it.tripulacion}, ${it.recompensa}, ${it.rango}")
            }
        }
        return Ok(Unit)
    }
}