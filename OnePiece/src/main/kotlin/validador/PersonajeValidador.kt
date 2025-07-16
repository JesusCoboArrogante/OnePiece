package org.example.validador

import com.github.michaelbull.result.Err
import com.github.michaelbull.result.Ok
import com.github.michaelbull.result.Result
import org.example.error.PersonajeError
import org.example.models.Marine
import org.example.models.Personaje
import org.example.models.Pirate
import org.example.models.Shichibukai
import org.lighthousegames.logging.logging

class PersonajeValidador: Validador<Personaje, PersonajeError> {
    private val log = logging()
    override fun validate(t: Personaje): Result<Personaje, PersonajeError> {
        if (t.nombre.isBlank()){
            return Err(PersonajeError.ValidationError("el nombre no puede estar en blanco"))

        }
        if (t.activo){
            if (!t.vivo){
                return Err(PersonajeError.ValidationError("Si esta en activo tiene que estar vivo"))
            }
        }
        when(t){
            is Pirate -> validatorPirate(t)
            is Shichibukai -> validatorShichibukai(t)

        }

        return Ok(t)
    }

     private fun validatorPirate(t: Pirate): Result<Pirate, PersonajeError> {
        if (t.recompensa < 0){
            return Err(PersonajeError.ValidationError("Los piratas deben tener una recompensa superior a 0"))
        }
         return Ok(t)
    }

     private fun validatorShichibukai(t: Shichibukai): Result <Shichibukai, PersonajeError>{

        if (t.recompensa < 0){
            return Err(PersonajeError.ValidationError("Los shichibukai deben tener una recompensa superior a 0"))
        }
        return Ok(t)
    }
}