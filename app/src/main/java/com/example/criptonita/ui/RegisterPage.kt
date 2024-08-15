package com.example.criptonita.ui

import androidx.activity.ComponentActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.criptonita.R
import com.example.criptonita.showToastAndFinish
import com.example.criptonita.ui.theme.blackBackground
import com.example.criptonita.ui.theme.primaryColorGreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterPage(activity: ComponentActivity) {
    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(blackBackground)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.criptonita_logo),
            contentDescription = "CriptoNita Logo",
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .height(200.dp),
            contentScale = ContentScale.Fit
        )
        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Nome de Usuário") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.padding(8.dp))
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("E-mail") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.padding(8.dp))
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Senha") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.padding(8.dp))
        OutlinedTextField(
            value = confirmPassword,
            onValueChange = { confirmPassword = it },
            label = { Text("Confirmar Senha") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.padding(16.dp))
        Button(
            onClick = { showToastAndFinish(activity) },
            enabled = username.isNotEmpty() && email.isNotEmpty() &&
                    password.isNotEmpty() && confirmPassword.isNotEmpty() &&
                    password == confirmPassword,
            colors = ButtonDefaults.buttonColors(
                containerColor = primaryColorGreen,
                contentColor = Color.Black
            ),
        ) {
            Text(
                "Registrar",
                style = TextStyle(fontWeight = FontWeight.Bold)
            )
        }
        Spacer(modifier = Modifier.padding(8.dp))
        Button(
            onClick = { /* Limpar campos */ },
            colors = ButtonDefaults.buttonColors(
                containerColor = primaryColorGreen,
                contentColor = Color.Black
            ),
        ) {
            Text(
                "Limpar",
                style = TextStyle(fontWeight = FontWeight.Bold)
            )
        }
    }
}