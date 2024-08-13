package com.example.criptonita

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.criptonita.ui.RegisterPage
import com.example.criptonita.ui.theme.CriptoNitaTheme

class RegisterActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CriptoNitaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    RegisterPage(this)
                }
            }
        }
    }
}

fun showToastAndFinish(activity: ComponentActivity) {
    // Lógica para mostrar o Toast e finalizar a atividade
    Toast.makeText(activity, "Registro OK!", Toast.LENGTH_LONG).show()
    activity.finish()
}

@Preview(showBackground = true)
@Composable
fun PreviewRegisterPage() {
    CriptoNitaTheme {
        RegisterPage(ComponentActivity())
    }
}