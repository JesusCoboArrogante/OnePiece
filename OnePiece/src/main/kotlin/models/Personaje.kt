package org.example.models

import java.time.LocalDateTime

abstract class Personaje(
    var id: Long,
    val nombre:String,
    val apodo:String,
    val haki:Boolean,
    val fruta:Boolean,
    val vivo: Boolean,
    val activo: Boolean,
    val tipo: String,
    val createAt: LocalDateTime,
    val updateAt: LocalDateTime
    )