package org.example.repository

import org.example.models.Personaje

interface PersonajeRepository <T,U>: CrudRepository<Long,Personaje>{
}