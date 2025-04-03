package org.example.models

import java.time.LocalDateTime

abstract class Personaje(
    val nombre:String,
    val apodo:String,
    val haki:Boolean,
    val fruta:Boolean,
    val vivo: Boolean,
    val activo: Boolean,
    val createAt: LocalDateTime,
    val updateAt: LocalDateTime
    ) {
}