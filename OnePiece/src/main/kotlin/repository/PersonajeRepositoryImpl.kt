package org.example.repository

import main.kotlin.dao.PersonajeDao
import org.example.dao.PersonajeEntity
import org.example.extension.copy
import org.example.mapper.toEntity
import org.example.mapper.toModel
import org.example.models.Marine
import org.example.models.Personaje
import org.example.models.Pirate
import org.example.models.Shichibukai
import java.time.LocalDateTime

class PersonajeRepositoryImpl (
    private  val dao: PersonajeDao
): PersonajeRepository<Long,Personaje> {
    override fun save(entity: Personaje): Personaje {
        val time = LocalDateTime.now()
        val guardarPersonaje =
            when(entity){
                is Pirate -> entity.copy(time = time).toEntity()
                is  Marine -> entity.copy(time = time).toEntity()
                is Shichibukai -> entity.copy(time = time).toEntity()
                else -> null
            }
        val generarId = dao.save(guardarPersonaje!!).toLong()
        val savePersonaje = dao.findById(generarId)!!.toModel()
        return savePersonaje
    }

    override fun delete(id: Long): Personaje? {
        val eliminarPersonaje: Personaje? = dao.findById(id)?.toModel()
        if (eliminarPersonaje == null){
            return null
        }
        dao.deleter(id)
        return eliminarPersonaje
    }

    fun update(id: Long, personaje: Personaje): Personaje? {
        val actualizarPersonaje:PersonajeEntity? = dao.findById(id)
        if (actualizarPersonaje == null){
            return null
        }
        val time = LocalDateTime.now()
        val personajeUpdate = actualizarPersonaje.copy(updateAt = time).toModel()
        dao.update(actualizarPersonaje)
        return personajeUpdate
    }

    override fun getAll(): List<Personaje> {
        return dao.findAll().map { it.toModel() }
    }

    override fun getById(id: Long): Personaje? {
        return dao.findById(id)?.toModel()
    }
}