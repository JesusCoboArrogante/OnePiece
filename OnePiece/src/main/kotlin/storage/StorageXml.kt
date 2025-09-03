package org.example.storage

import com.github.michaelbull.result.Err
import com.github.michaelbull.result.Ok
import com.github.michaelbull.result.Result
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import nl.adaptivity.xmlutil.serialization.XML
import org.example.dto.FraccionDTO
import org.example.dto.PersonajeDTO
import org.example.dto.PersonajeXmlDto
import org.example.error.PersonajeError
import org.example.mapper.toModel
import org.example.mapper.toXmlDto
import org.example.models.Marine
import org.example.models.Personaje
import org.example.models.Pirate
import org.example.models.Shichibukai
import java.io.File


class StorageXml:Storage {
    override fun leer(archivo: File): Result<List<Personaje>, PersonajeError> {
        if (!archivo.isFile|| !archivo.exists() || !archivo.canRead()){
            return Err(PersonajeError.StorageError("el archivo no se puede leer, no es un archivo  o no se puede leer"))
        }
        val xml = XML{}
        val xmlString = archivo.readText()
        val listaPersonajeDTO = xml.decodeFromString <FraccionDTO>(xmlString)
        val listaFraccionDTO = listaPersonajeDTO.fraccion
        val listaPersonaje = listaFraccionDTO.map { it.toModel() }
        return Ok(listaPersonaje)

    }

    override fun escribir(fraccion: List<Personaje>, archivo: File): Result<Unit, PersonajeError> {
        if (!archivo.parentFile.isDirectory||!archivo.parentFile.exists()) {
            return Err(PersonajeError.StorageError("el directorio no existe"))
        }
            val xml = XML{indent = 4}
            val listaPersonajeDto: List<PersonajeXmlDto> = fraccion.mapNotNull {
                when (it){
                    is Pirate -> {it.toXmlDto()}
                    is Marine -> {it.toXmlDto()}
                    is Shichibukai -> {it.toXmlDto()}
                    else -> null
                }
            }
        val fraccionDto = FraccionDTO(listaPersonajeDto)
        val xmlString = xml.encodeToString<FraccionDTO>(fraccionDto)
        archivo.writeText(xmlString)
        return Ok(Unit)

    }
}