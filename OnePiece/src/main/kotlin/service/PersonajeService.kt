package org.example.service
import com.github.michaelbull.result.Result
import org.example.error.PersonajeError
import org.example.models.Personaje

interface PersonajeService {
    fun importFromFile(filePath: String): Result <List<Personaje>, PersonajeError>
    fun exportToFile(filePath: String)

    fun getAll(): List<Personaje>
    fun getById(id: Long): Result<Personaje, PersonajeError>
    fun save (personaje: Personaje): Result<Personaje, PersonajeError>
    fun update (id: Long, personaje: Personaje): Result<Personaje, PersonajeError>
    fun deleter (id: Long): Result<Personaje, PersonajeError>
}