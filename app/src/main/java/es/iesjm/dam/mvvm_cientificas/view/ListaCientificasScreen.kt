//Integra la navegación desde las tarjetas.

package es.iesjm.dam.mvvm_cientificas.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import es.iesjm.dam.mvvm_cientificas.R
import es.iesjm.dam.mvvm_cientificas.data.MujerStemEntity
import es.iesjm.dam.mvvm_cientificas.viewmodel.CientificasViewModel


/** Me gusta estructurar la app de esta forma, creo una Screen donde van todos los parametros y creo
 * una segunda donde los paso y en caso de ser necesario lo distribuyo a diferentes componentes
 * */
@Composable
fun ListaCientificasScreen(
    viewModel: CientificasViewModel = viewModel(factory = CientificasViewModel.factory),
    navController: NavController
) {
    val listaStemPorNombre by viewModel.getFullStemById().collectAsState(emptyList())
    CientificaDetalle(
        listaCientificas = listaStemPorNombre,
        navController = navController
    )
}

@Composable
fun CardDetalles(
    navController: NavController,
    cientifica: MujerStemEntity,
    modifier: Modifier = Modifier
) {
    Card(
        modifier= Modifier
            .padding(5.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardColors(containerColor =
            Color.LightGray,
            CardDefaults.cardColors().contentColor,
            CardDefaults.cardColors().disabledContentColor,
            CardDefaults.cardColors().disabledContainerColor )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { navController.navigate("detalle/${cientifica.nombre}") }
                .padding(dimensionResource(R.dimen.padding_medium)),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column (
                Modifier
                    .fillMaxWidth()
                    .heightIn(min = 60.dp, max = 200.dp)
            ) {
                Text(
                    text = cientifica.nombre,
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontSize = dimensionResource(R.dimen.font_large).value.sp,
                        fontWeight = FontWeight(300)
                    )
                )
                Text(
                    text = cientifica.logros
                )
            }

        }
    }
}

/** Muestra el nombre y el logro de una lista de cientíoficas*/
@Composable
fun CientificaDetalle(
    navController: NavController,
    listaCientificas: List<MujerStemEntity>,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = contentPadding,
    ) {
        items(
            items = listaCientificas,
            key = { item: MujerStemEntity -> item.id }
        ) { cientifica ->
            CardDetalles(navController,cientifica)
        }
    }
}
