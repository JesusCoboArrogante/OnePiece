package org.example.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("fraccion")
data class FraccionDTO (
    val fraccion: List<PersonajeXmlDto>

): java.io.Serializable

