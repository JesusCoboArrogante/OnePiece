package org.example.storage

import com.github.michaelbull.result.Result
import org.example.error.PersonajeError
import org.example.models.Personaje
import java.io.File

interface Storage {
    fun leer (archivo: File): Result<List<Personaje>,PersonajeError>
    fun escribir (fraccion: List<Personaje>,archivo: File): Result<Unit,PersonajeError>
}