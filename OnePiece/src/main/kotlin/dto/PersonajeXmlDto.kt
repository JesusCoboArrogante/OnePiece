package org.example.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import nl.adaptivity.xmlutil.serialization.XmlElement

@Serializable
@SerialName("Personaje")
data class PersonajeXmlDto(
    @SerialName("id")
    var id: Long,
    @SerialName("nombre")
    @XmlElement
    val nombre: String,
    @SerialName("apodo")
    @XmlElement
    val apodo: String,
    @SerialName("haki")
    @XmlElement
    val haki: Boolean,
    @SerialName("fruta")
    @XmlElement
    val fruta: Boolean,
    @SerialName("vivo")
    @XmlElement
    val vivo: Boolean,
    @SerialName("activo")
    @XmlElement
    val activo:Boolean,
    @SerialName("tipo")
    @XmlElement
    val tipo: String,
    @SerialName("createAt")
    @XmlElement
    val createAt: String,
    @SerialName("updateAt")
    @XmlElement
    val updateAt: String,
    @SerialName("tripulacion")
    @XmlElement
    val tripulacion: String?,
    @SerialName("recompensa")
    @XmlElement
    val recompensa: Int?,
    @SerialName("rango")
    @XmlElement
    val rango: String?
): java.io.Serializable {

}
