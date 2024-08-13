package com.example.criptonita.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.criptonita.R

@Preview
@Composable
fun AlertListPage() {
    var showDialog by remember { mutableStateOf(false) }
    var alerts by remember { mutableStateOf(listOf<Pair<String, String>>()) }

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { showDialog = true }
            ) {
                Icon(Icons.Default.Add, contentDescription = "Adicionar Alerta")
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            // Renderiza a lista de alertas
            alerts.forEach { (criptoName, value) ->
                AlertItem(criptoName = criptoName, value = value)
            }
        }
        // Alerta 1
        AlertItem(criptoName = "BTC", value = "320.000BRL")

        // Alerta 2
        AlertItem(criptoName = "ETH", value = "16.000BRL")

        if (showDialog) {
            CreateAlertDialog(
                onDismiss = { showDialog = false },
                onConfirm = { alertType, currency, value, frequency ->
                    // Adiciona o novo alerta à lista
                    alerts = alerts + Pair(currency, value)
                    showDialog = false
                }
            )
        }
    }
}

@Composable
fun AlertItem(criptoName: String, value: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "$criptoName Value $value")
            Row {
                IconButton(onClick = { /* Ação para remover alerta */ }) {
                    Icon(Icons.Default.Close, contentDescription = "Remover Alerta")
                }
                IconButton(onClick = { /* Ação para editar alerta */ }) {
                    Icon(Icons.Default.Edit, contentDescription = "Editar Alerta")
                }
            }
        }
    }
}

@Composable
fun CreateAlertDialog(onDismiss: () -> Unit, onConfirm: (alertType: String, currency: String, value: String, frequency: String) -> Unit) {
    val alertType = remember { mutableStateOf("") }
    val currency = remember { mutableStateOf("") }
    val value = remember { mutableStateOf("") }
    val frequency = remember { mutableStateOf("") }

    Dialog(onDismissRequest = { onDismiss() }) {
        Card(shape = RoundedCornerShape(16.dp)) {
            Column(modifier = Modifier.padding(20.dp)) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "Criar Alerta")
                    Icon(
                        imageVector = Icons.Filled.Close,
                        contentDescription = "",
                        modifier = Modifier.clickable { onDismiss() }
                    )
                }
                Spacer(modifier = Modifier.height(20.dp))

                // Campo Tipo de Alerta
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    label = { Text(text = "Tipo de Alerta") },
                    value = alertType.value,
                    onValueChange = { alertType.value = it }
                )
                Spacer(modifier = Modifier.height(20.dp))

                // Campo Seleção de Moeda
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    label = { Text(text = "Selecione a Moeda") },
                    value = currency.value,
                    onValueChange = { currency.value = it }
                )
                Spacer(modifier = Modifier.height(20.dp))

                // Campo Valor
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    label = { Text(text = "Insira o Valor") },
                    value = value.value,
                    onValueChange = { value.value = it }
                )
                Spacer(modifier = Modifier.height(20.dp))

                // Campo Frequência
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    label = { Text(text = "Frequência") },
                    value = frequency.value,
                    onValueChange = { frequency.value = it }
                )
                Spacer(modifier = Modifier.height(20.dp))

                Button(
                    onClick = { onConfirm(alertType.value, currency.value, value.value, frequency.value) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                ) {
                    Text(text = "Criar Alerta")
                }
            }
        }
    }
}