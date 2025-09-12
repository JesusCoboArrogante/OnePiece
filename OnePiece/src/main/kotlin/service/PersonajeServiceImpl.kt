package org.example.service

import com.github.benmanes.caffeine.cache.Cache
import com.github.michaelbull.result.Err
import com.github.michaelbull.result.Ok
import com.github.michaelbull.result.Result
import org.example.error.PersonajeError
import org.example.models.Personaje
import org.example.repository.PersonajeRepositoryImpl
import org.example.validador.PersonajeValidador

class PersonajeServiceImpl(
    private val repository: PersonajeRepositoryImpl,
    private  val cache: Cache<Long, Personaje>,
    private  val validador: PersonajeValidador,
):PersonajeService {
    override fun importFromFile(filePath: String): Result<List<Personaje>, PersonajeError> {
        TODO("Not yet implemented")
    }

    override fun exportToFile(filePath: String) {
        TODO("Not yet implemented")
    }

    override fun getAll(): List<Personaje> {
        return repository.getAll()
    }

    override fun getById(id: Long): Result<Personaje, PersonajeError> {
        var result = cache.getIfPresent(id)
        if (result == null){
            result = repository.getById(id)
            if (result == null){
                return Err(PersonajeError.NotFoundError("Personaje no encontrado por su id $id"))
            }else {
                cache.put(id,result)
                return Ok(result)
            }
        }
        return Ok(result)
    }

    override fun save(personaje: Personaje): Result<Personaje, PersonajeError> {
        validador.validate(personaje)
        return Ok(repository.save(personaje))
    }

    override fun update(id: Long, personaje: Personaje): Result<Personaje, PersonajeError> {
        validador.validate(personaje)
        val actualizar: Personaje? = repository.update(id, personaje)
        if (actualizar == null){
            return Err(PersonajeError.NotFoundError("Personaje no encontrado con el id $id"))
        }else {
            cache.invalidate(id)
        }
        return Ok(actualizar)
    }

    override fun deleter(id: Long): Result<Personaje, PersonajeError> {
        val borrar: Personaje? = repository.delete(id)
        if (borrar == null){
            return Err(PersonajeError.NotFoundError("Personaje no encontrado con el id $id"))
        }else{
            cache.invalidate(id)
        }
        return Ok(borrar)
    }

}