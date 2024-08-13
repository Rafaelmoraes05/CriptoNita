package com.example.criptonita.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.criptonita.R
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.Alignment
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun FavoritePage() {
    Scaffold(
    ) { innerPadding ->
        LazyColumn(
            contentPadding = innerPadding,
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
        ) {
            items(getFavoriteCryptocurrencyList()) { crypto ->
                FavoriteCryptoItem(crypto)
            }
        }
    }
}

@Composable
fun FavoriteCryptoItem(crypto: Cryptocurrency) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(Color.Black),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.Star,
            contentDescription = "${crypto.name} favorite icon",
            tint = Color.Yellow, // Ícone de estrela com cor amarela
            modifier = Modifier.size(32.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(
                text = crypto.name,
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = crypto.value,
                color = Color.Green,
                fontSize = 14.sp
            )
        }
    }
}

fun getFavoriteCryptocurrencyList(): List<Cryptocurrency> {
    return listOf(
        Cryptocurrency("Bitcoin", "BTC", "R$ 330.447,13", Icons.Default.Star),
        Cryptocurrency("Ethereum", "ETH", "R$ 14.800,37", Icons.Default.Star),
        // Adicione aqui outras criptomoedas favoritas...
    )
}