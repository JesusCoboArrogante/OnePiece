package org.example.error

sealed class PersonajeError (val mensaje:String) {
    class NotFoundError(id:Int) : PersonajeError ("Personaje no encontrado su id: $id")
    class ValidationError (mensaje: String) : PersonajeError ("Personaje no valido: $mensaje")

}