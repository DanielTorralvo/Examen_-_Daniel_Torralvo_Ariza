package es.iesjm.dam.mvvm_cientificas.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import es.iesjm.dam.mvvm_cientificas.R
import kotlinx.coroutines.delay

//Pantalla que muestra una imagen stática
@Composable
fun SplashScreen(navController: NavController){
    //Lanzo una corrutina para darle un delay a la navegación
    LaunchedEffect(key1 = true) {
        delay(3000)
        navController.popBackStack()
        navController.navigate("lista")
    }
    Splash()
}

@Composable
fun Splash() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(painter = painterResource(R.drawable.mujeres_stem),
            contentDescription = "",
            modifier = Modifier
                .shadow(10.dp, RoundedCornerShape(60.dp))
                .clip(CircleShape)
        )
        Spacer(Modifier.padding(6.dp))
        Text("Mujeres en la Ciencia", fontSize = 30.sp, fontWeight = FontWeight.SemiBold)
    }
}