
//Configura la navegación como parte del contenido principal.

package es.iesjm.dam.mvvm_cientificas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import es.iesjm.dam.mvvm_cientificas.navigation.AppNavigation
import es.iesjm.dam.mvvm_cientificas.ui.theme.MVVM_CientificasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MVVM_CientificasTheme {
                val navController = rememberNavController()
                AppNavigation(navController = navController)
            }
        }
    }
}
