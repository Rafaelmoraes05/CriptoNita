package com.example.criptonita.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
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

@Preview
@Composable
fun FavoritePage() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.teal_700))
            .wrapContentSize(Alignment.Center)
    ) {
        Text(
            text = "Moedas Favoritas",
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            fontSize = 20.sp
        )
    }
}