package com.vivek.jetpackcompose.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.FormatQuote
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Preview
@Composable
fun QuoteListItem (){
    Box (
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize(1f)
            .background(
            Brush.sweepGradient(
                colors = listOf(
                    Color(0xFF673AB7),
                    Color(0xFFA693C7)
                )
            )
        )
    ){

        Card(
            elevation = CardDefaults.cardElevation(
                defaultElevation = 4.dp
            ),
            modifier = Modifier.padding(8.dp)
        ) {
            Row(
                Modifier.padding(16.dp)
            ) {
                Image(
                    contentDescription = "close",
                    imageVector = Icons.Filled.FormatQuote,
                    colorFilter = ColorFilter.tint(Color.White),
                    alignment = Alignment.TopStart,
                    modifier = Modifier
                        .size(40.dp)
                        .rotate(180f)
                        .background(Color.Black)
                )
                Spacer(modifier = Modifier.padding(4.dp))
                Column(modifier = Modifier.weight(1f)) {
                    //weight to column to give space
                    Text(
                        text = "The subtle art of not giving a F***",
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 5.dp)
                    )
                    Box(
                        modifier = Modifier
                            .background(Color(0xFFE91E63))
                            .fillMaxWidth(.4f)
                            .height(1.dp)
                    )
                    Text(
                        text = "Author",
                        fontFamily = FontFamily.Cursive,
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
        }
    }
}

