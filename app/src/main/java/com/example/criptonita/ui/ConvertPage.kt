package com.example.criptonita.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.ui.Modifier
import com.example.criptonita.R
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.criptonita.ui.theme.blackBackground
import com.example.criptonita.ui.theme.primaryColorGreen


@Preview
@Composable
fun ConvertPage() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(blackBackground)

    ) {
        // Campo para selecionar a Criptomoeda
        OutlinedTextField(
            value = "BTC",
            onValueChange = {},
            label = { Text("Criptomoeda") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
        )

        // Campo para selecionar a Moeda
        OutlinedTextField(
            value = "BRL",
            onValueChange = {},
            label = { Text("Moeda") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
        )

        // Campo para inserir o valor
        OutlinedTextField(
            value = "1",
            onValueChange = {},
            label = { Text("Insira o Valor") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        // Exibição do valor convertido
        Text(
            text = "351.339,33BRL",
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(vertical = 16.dp),
            fontSize = 24.sp,
            color = Color.White
        )

        // Botão para converter
        Button(
            onClick = { /* Ação de conversão */ },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(vertical = 16.dp),
            colors = ButtonDefaults.buttonColors(primaryColorGreen)
        ) {
            Text(text = "Converter")
        }
    }
}
