package org.example.error

sealed class PersonajeError (val messaje:String) {
    class NotFoundError(messaje: String): PersonajeError ("Personaje no encontrado su id: $messaje")
    class ValidationError (messaje: String): PersonajeError ("Personaje no valido: $messaje")
    class StorageError (messaje: String): PersonajeError ("Error en el Storaje: $messaje")

}