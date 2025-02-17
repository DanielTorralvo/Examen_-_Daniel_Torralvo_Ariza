package es.iesjm.dam.mvvm_cientificas.data

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

/**
 * Proporciona acceso a operaciones de lectura/escritura en la tabla de programación.
 * Utilizado por los ViewModel para formatear
 * los resultados de la consulta para su uso en la interfaz de usuario.
 */
@Dao
interface MujerStemDao {
    //Obtengo la lista por orden de ID
    @Query("SELECT * FROM cientificas_database ORDER BY id ASC ")
    fun getAllById(): Flow<List<MujerStemEntity>>

    //Obtengo la lista por orden de NOMBRE
    @Query("SELECT * FROM cientificas_database ORDER BY nombre ASC ")
    fun getAllByName(): Flow<List<MujerStemEntity>>

    //Filtro la lista hacia una por nombre, para poder implementar un motor de busqueda
    @Query("SELECT * FROM cientificas_database WHERE nombre = :nombreStem ")
    fun getByName(nombreStem: String): Flow<List<MujerStemEntity>>
}