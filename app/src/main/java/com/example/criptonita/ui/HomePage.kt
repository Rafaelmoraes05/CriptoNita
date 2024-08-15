package com.example.criptonita.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.criptonita.R


@Composable
fun HomePage() {
    Scaffold(
    ) { innerPadding ->
        LazyColumn(
            contentPadding = innerPadding,
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
        ) {
            item {
                Image(
                    painter = painterResource(id = R.drawable.grafico),
                    contentDescription = "Grafico",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(360.dp),
                    contentScale = ContentScale.Crop
                )
            }

            items(getCryptocurrencyList()) { crypto ->
                CryptoItem(crypto)
            }
        }
    }
}

data class Cryptocurrency(val name: String, val symbol: String, val value: String, val icon: ImageVector)

@Composable
fun CryptoItem(crypto: Cryptocurrency) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp, horizontal = 6.dp)
            .background(Color.Black),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = crypto.icon,
            contentDescription = "${crypto.name} icon",
            tint = Color.White,
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

fun getCryptocurrencyList(): List<Cryptocurrency> {
    return listOf(
        Cryptocurrency("Bitcoin", "BTC", "R$ 330.447,13", Icons.Default.KeyboardArrowRight),
        Cryptocurrency("VeChain", "VET", "R$ 0,13", Icons.Default.KeyboardArrowRight),
        Cryptocurrency("VeThor Token", "VTHO", "R$ 0,0112", Icons.Default.KeyboardArrowRight),
        Cryptocurrency("Vara", "VARA", "R$ 0,13", Icons.Default.KeyboardArrowRight),
        Cryptocurrency("Ethereum", "ETH", "R$ 14.800,37", Icons.Default.KeyboardArrowRight),
        Cryptocurrency("Polygon", "MATIC", "R$ 2,31", Icons.Default.KeyboardArrowRight)
    )
}