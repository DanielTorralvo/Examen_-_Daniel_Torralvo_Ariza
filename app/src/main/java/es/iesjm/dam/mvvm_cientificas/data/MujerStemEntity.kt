package es.iesjm.dam.mvvm_cientificas.data

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cientificas_database")
data class MujerStemEntity (
    /**
     * He tenido que modificas los valores de la primary_key y los not null en DB_Browser,
     * porque al importarlos de csv, conserva los datos pero no la esctructura loquica de la tabla*/

    @PrimaryKey(autoGenerate = true)
    @NonNull
    val id: Int,

    @NonNull
    val nombre: String,

    @NonNull
    val logros: String,

    @NonNull
    val biografia: String
)