
//Configura la navegación como parte del contenido principal.

package es.iesjm.dam.mvvm_cientificas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import es.iesjm.dam.mvvm_cientificas.navigation.AppNavigation

import es.iesjm.dam.mvvm_cientificas.ui.theme.MVVM_CientificasTheme


/***
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import es.iesjm.dam.mvvm_cientificas.ui.theme.MVVM_CientificasTheme

***/

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
