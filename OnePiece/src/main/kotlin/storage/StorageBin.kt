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
import java.io.RandomAccessFile


class StorageBin:Storage {
    override fun leer(archivo: File): Result<List<Personaje>, PersonajeError> {
        if (!archivo.exists() || !archivo.isFile || !archivo.canRead())return  Err(PersonajeError.StorageError("Error el archivo no existe, no es un archivo o no se puede leer"))
        val fraccion = mutableListOf<PersonajeDTO>()

        RandomAccessFile(archivo,"r").use{ raf ->
            while (raf.filePointer < raf.length()){
                var id = raf.readLong()
                val nombre = raf.readUTF()
                val apodo = raf.readUTF()
                val haki = raf.readBoolean()
                val fruta = raf.readBoolean()
                val vivo = raf.readBoolean()
                val activo = raf.readBoolean()
                val tipo = raf.readUTF()
                val createAt = raf.readUTF()
                val updateAt = raf.readUTF()
                if (tipo == "pirata"){
                    val tripulacion = raf.readUTF()
                    val recompensa = raf.readInt()
                    val personajePirata= PersonajeDTO(
                        id,  nombre, apodo, haki, fruta,
                        vivo, activo, tipo, createAt,
                        updateAt, recompensa, tripulacion,rango = null
                    )
                    fraccion.add(personajePirata)

                } else if (tipo == "marine"){
                    val rango = raf.readUTF()
                    val personajeMarine = PersonajeDTO(
                        id, nombre, apodo, haki, fruta,
                        vivo, activo, tipo, createAt,
                        updateAt, recompensa = null,
                        tripulacion = null, rango
                    )
                    fraccion.add(personajeMarine)
                }else{
                    val tripulacion = raf.readUTF()
                    val recompensa = raf.readInt()
                    val rango = raf.readUTF()
                    val personajeShichibukai = PersonajeDTO(
                        id, nombre, apodo, haki, fruta,
                        vivo, activo, tipo, createAt,
                        updateAt, recompensa, tripulacion, rango
                    )
                    fraccion.add(personajeShichibukai)
                }
            }
        }
        return Ok(fraccion.map { it.toModel() })
    }

    override fun escribir(fraccion: List<Personaje>, archivo: File): Result<Unit, PersonajeError> {
        if (!archivo.parentFile.exists() || !archivo.parentFile.isDirectory){
            return Err(PersonajeError.StorageError("el directorio del fichero no existe"))
        }
        val personajeDTO = fraccion.map {
            when (it){
                is Pirate -> {it.toDto()}
                is Marine -> {it.toDto()}
                is Shichibukai -> {it.toDto()}
                else -> null
            }
        }
        RandomAccessFile(archivo,"rw").use { raf ->
            raf.setLength(0)
            for (personaje in personajeDTO){
                if (personaje?.tipo == "Pirata"){
                    raf.writeLong(personaje.id)
                    raf.writeUTF(personaje.nombre)
                    raf.writeUTF(personaje.apodo)
                    raf.writeBoolean(personaje.haki)
                    raf.writeBoolean(personaje.fruta)
                    raf.writeBoolean(personaje.vivo)
                    raf.writeBoolean(personaje.activo)
                    raf.writeUTF(personaje.tipo)
                    raf.writeUTF(personaje.createAt)
                    raf.writeUTF(personaje.updateAt)
                    raf.writeUTF(personaje.tripulacion!!)
                    raf.writeInt(personaje.recompensa!!)
                } else if (personaje?.tipo == "Marine"){
                    raf.writeLong(personaje!!.id)
                    raf.writeUTF(personaje.nombre)
                    raf.writeUTF(personaje.apodo)
                    raf.writeBoolean(personaje.haki)
                    raf.writeBoolean(personaje.fruta)
                    raf.writeBoolean(personaje.vivo)
                    raf.writeBoolean(personaje.activo)
                    raf.writeUTF(personaje.tipo)
                    raf.writeUTF(personaje.createAt)
                    raf.writeUTF(personaje.updateAt)
                    raf.writeUTF(personaje.rango!!)
                }else{
                    raf.writeLong(personaje!!.id)
                    raf.writeUTF(personaje.nombre)
                    raf.writeUTF(personaje.apodo)
                    raf.writeBoolean(personaje.haki)
                    raf.writeBoolean(personaje.fruta)
                    raf.writeBoolean(personaje.vivo)
                    raf.writeBoolean(personaje.activo)
                    raf.writeUTF(personaje.tipo)
                    raf.writeUTF(personaje.createAt)
                    raf.writeUTF(personaje.updateAt)
                    raf.writeUTF(personaje.rango!!)
                    raf.writeUTF(personaje.tripulacion!!)
                    raf.writeInt(personaje.recompensa!!)
                }
            }
        }
        return Ok(Unit)
    }

}