//Gestiona la lógica de negocio y expone los datos para la vista.

package es.iesjm.dam.mvvm_cientificas.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import es.iesjm.dam.mvvm_cientificas.MujerStemApplication

import es.iesjm.dam.mvvm_cientificas.data.MujerStemDao
import es.iesjm.dam.mvvm_cientificas.data.MujerStemEntity
import es.iesjm.dam.mvvm_cientificas.model.Cientifica
import kotlinx.coroutines.flow.Flow

class CientificasViewModel(private val mujerStemDao: MujerStemDao) : ViewModel() {

    // Obtiene la lista de cioentificas ordenadas por nombre desde Room DB
    fun getFullStemByName(): Flow<List<MujerStemEntity>> = mujerStemDao.getAllByName()

    // Obtiene la lista de cioentificas ordenadas por id desde Room DB
    fun getFullStemById(): Flow<List<MujerStemEntity>> = mujerStemDao.getAllById()

    // Obtiene una lista de nombres
    fun getScheduleFor(nombre: String): Flow<List<MujerStemEntity>> =
        mujerStemDao.getByName(nombre)

    companion object {
        val factory : ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as MujerStemApplication)
                CientificasViewModel(application.database.mujerStemDao())
            }
        }
    }
}
