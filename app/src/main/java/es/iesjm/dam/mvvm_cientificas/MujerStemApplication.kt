package es.iesjm.dam.mvvm_cientificas

import android.app.Application
import es.iesjm.dam.mvvm_cientificas.data.AppDatabase

/**
 * La clase Application es una clase base en Android que contiene el estado global de la aplicación.
 *
 * AppDatabase.getDatabase(this) es una llamada a un método estático getDatabase en la clase AppDatabase.
 * */

class MujerStemApplication : Application() {
    val database: AppDatabase by lazy { AppDatabase.getDatabase(this) }
}