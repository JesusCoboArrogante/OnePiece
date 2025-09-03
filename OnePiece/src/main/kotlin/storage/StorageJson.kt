package org.example.storage

import com.github.michaelbull.result.Err
import com.github.michaelbull.result.Ok
import com.github.michaelbull.result.Result
import kotlinx.serialization.json.Json
import org.example.dto.PersonajeDTO
import org.example.error.PersonajeError
import org.example.mapper.toDto
import org.example.mapper.toModel
import org.example.models.Marine
import org.example.models.Personaje
import org.example.models.Pirate
import org.example.models.Shichibukai
import java.io.File

class StorageJson: Storage {
    override fun leer(archivo: File): Result<List<Personaje>, PersonajeError> {
        if (!archivo.exists()||!archivo.isFile||!archivo.canRead()) return Err(PersonajeError.StorageError("el archivo no se puede leer, no es un archivo  o no se puede leer"))

        val json = Json { ignoreUnknownKeys = true}
        val jsonString = archivo.readText()
        val listaPersonajeDto: List<PersonajeDTO> = json.decodeFromString(jsonString)
        val listaPersonaje = listaPersonajeDto.map { it.toModel()}
        return Ok(listaPersonaje)
    }

    override fun escribir(fraccion: List<Personaje>, archivo: File): Result<Unit, PersonajeError> {
        if (!archivo.parentFile.exists() || !archivo.parentFile.isDirectory){
            return Err(PersonajeError.StorageError("no esta el directorio"))
        }
        val json = Json{ignoreUnknownKeys = true; prettyPrint = true}
        val listaPersonajeDto: List<PersonajeDTO> = fraccion.mapNotNull {
            when (it){
                is Pirate -> {it.toDto()}
                is Marine -> {it.toDto()}
                is Shichibukai -> {it.toDto()}
                else -> null
            }
        }
        val jsonString: String = json.encodeToString(listaPersonajeDto)
        archivo.writeText(jsonString)
        return Ok(Unit)
    }
}