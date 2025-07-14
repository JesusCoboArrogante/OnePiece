package main.kotlin.dao
import org.jdbi.v3.sqlobject.kotlin.RegisterKotlinMapper
import org.example.dao.PersonajeEntity
import org.example.models.Personaje
import org.example.models.Rango
import org.jdbi.v3.sqlobject.customizer.Bind
import org.jdbi.v3.sqlobject.customizer.BindBean
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys
import org.jdbi.v3.sqlobject.statement.SqlQuery
import org.jdbi.v3.sqlobject.statement.SqlUpdate
import java.time.LocalDateTime

@RegisterKotlinMapper(PersonajeEntity::class)
interface PersonajeDao {
    //seleccionar todos los personajes
    @SqlQuery("SELECT * FROM personajesOnePiece")
    fun findAll(): List<PersonajeEntity>

    //buscar por id puede haber id nulos
    @SqlQuery("SELECT * FROM personajesOnePiece WHERE id = :id")
    fun findById(@Bind("id") id: Int):PersonajeEntity?

    //añadir personaje
    @SqlUpdate ("insert into personajesOnePiece (nombre, apado, haki, fruta, vivo, activo, createAt, updateAt, recompesa, tripulacion, rango) VALUES (:nombre, :apado, :haki, :fruta, :vivo, :activo, :createAt, :updateAt, :recompesa, :tripulacion, :rango)")
    @GetGeneratedKeys ("id") //obtener el id de forma automatica
    fun save (@BindBean personaje: PersonajeEntity):Int

    @SqlUpdate ("insert into personajesOnePiece (nombre, apado, haki, fruta, vivo, activo, createAt, updateAt, recompesa, tripulacion, rango) VALUES (:nombre, :apado, :haki, :fruta, :vivo, :activo, :createAt, :updateAt, :recompesa, :tripulacion, :rango)")
    @GetGeneratedKeys ("id")
    fun saveWithFields(
        @Bind("nombre") nombre: String,
        @Bind("apodo") apodo: String,
        @Bind("haki") haki: Boolean,
        @Bind("fruta") fruta: Boolean,
        @Bind("vivo") vivo: Boolean,
        @Bind("activo") activo: Boolean,
        @Bind("createAt") createAt: LocalDateTime,
        @Bind("updateAt") updateAt: LocalDateTime,
        @Bind("recompensa") recompensas: Int,
        @Bind("tripulacion") tripulacion: String,
        @Bind("rango") rango: Rango
    ):Int

    @SqlUpdate ("UPDATE personajesOnePiece SET nombre =:nombre, apodo =:apado, haki =:haki, fruta=:fruta, vivo=:vivo, activo=:activo, createAT=:createAt, updateAt=:updateAt, recompensa=:recompesa, tripulacion=:tripulacion, rango=:rango WHERE id = :id")
    fun update (@BindBean personaje: PersonajeEntity):Int

    @SqlUpdate ("DELETER FROM personajesOnePiece WHERE id =:id")
    fun deleter (@Bind("id") id: Int): Int

    //consultas secundarias
    @SqlQuery ("SELECT * FROM personajesOnePiece LIMIT  :LIMIT OFFSET :offset")
    fun findAll (@Bind("limit") limit:Int, @Bind("offset") offset:Int ):List<PersonajeEntity>

    //consultar por nonbre
    @SqlQuery ("SELECT * FROM personajesOnePiece WHERE LOWER (nombre) LIKE LOWER (:nombre)")
    fun findName (@Bind("nombre") nombre: String): List<PersonajeEntity>

    //consultar por recompensa
    @SqlQuery ("SELECT * FROM personajesOnePiece WHERE recompensa = :recompensa ")
    fun findbyrecompensa (@Bind("recompensa") recompensas: Int): List<PersonajeEntity>

    //ver el numero de personajes
    @SqlQuery ("SELECT COUNT(*) FROM personajesOnePiece")
    fun count():Int

    // ver recompensa maxima
    @SqlQuery("SELECT MAX (recompensa) From personajesOnePiece")
    fun maxRecompensa(): Int

    //ver recompensa minima
    @SqlQuery("SELECT MIN (recompensa) From personajesOnePiece")
    fun minRecompensa(): Int
}