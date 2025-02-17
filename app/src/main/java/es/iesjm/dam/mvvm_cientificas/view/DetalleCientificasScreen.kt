//Esta pantalla muestra información detallada de la científica seleccionada.

package es.iesjm.dam.mvvm_cientificas.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import es.iesjm.dam.mvvm_cientificas.data.MujerStemEntity

//Muestra todos los datos de una Científica
@Composable
fun DetalleCientificaScreen(cientifica: MujerStemEntity) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "Nombre: ${cientifica.nombre}",
            style = MaterialTheme.typography.titleLarge
        )
        Text(
            text = "Logros: ${cientifica.logros}",
            style = MaterialTheme.typography.bodyMedium
        )
        Text(
            text = "Biografía ampliada: ${cientifica.biografia}",
            style = MaterialTheme.typography.bodySmall
        )
        Text(
            text = "Dato adicional: Ejemplo de dato relevante",
            style = MaterialTheme.typography.bodySmall
        )
    }
}

