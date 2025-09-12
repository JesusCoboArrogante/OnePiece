package org.example.storage

import com.github.michaelbull.result.Ok
import com.github.michaelbull.result.Result
import org.example.error.PersonajeError
import org.example.models.Personaje
import java.io.File

class StorageImpl(
    private val storageCsv: StorageCsv = StorageCsv(),
    private val storageJson: StorageJson = StorageJson(),
    private val storageXml: StorageXml = StorageXml(),
    private val storageBin: StorageBin = StorageBin()

):Storage {
    override fun leer(archivo: File): Result<List<Personaje>, PersonajeError> {
        when{
            archivo.name.endsWith(".csv") -> {
                return storageCsv.leer(archivo)
            }
            archivo.name.endsWith(".json") -> {
                return storageJson.leer(archivo)
            }
            archivo.name.endsWith(".xml") -> {
                return storageXml.leer(archivo)
            }
            else -> {
                return storageBin.leer(archivo)
            }
        }
    }

    override fun escribir(fraccion: List<Personaje>, archivo: File): Result<Unit, PersonajeError> {
        when{
            archivo.name.endsWith(".csv") -> {
                return storageCsv.escribir(fraccion, archivo)
            }
            archivo.name.endsWith(".json") -> {
                return storageJson.escribir(fraccion, archivo)
            }
            archivo.name.endsWith(".xml") -> {
                return storageXml.escribir(fraccion, archivo)
            }
            archivo.name.endsWith(".bin") -> {
                return storageBin.escribir(fraccion, archivo)
            }
        }
        return Ok(Unit)
    }
}