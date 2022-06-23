package com.example.stormy.core.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.stormy.R

@Composable
fun Now(
    modifier: Modifier = Modifier,
    temperature: String = "25",
    icon: String = "",
    unit: String = "C",
    humidity: String = "30",
    wind: String = "35.4",
    feeling: String = "23",
) {

    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {

        Image(
            modifier = Modifier.size(100.dp),
            painter = painterResource(id = R.drawable.ic_sunny),
            contentDescription = "condition icon"
        )

        Row(modifier = Modifier) {
            Text(
                style = MaterialTheme.typography.headlineLarge,
                text = temperature
            )
            Text(
                style = MaterialTheme.typography.headlineSmall,
                text = "°$unit"
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            NowDetail(label = "Wind", value = "$wind Km/h")

            NowDetail(label = "Humidity", value = "$humidity%")

            NowDetail(label = "Feeling", value = "$feeling°")
        }
    }

}


@Preview(showBackground = true)
@Composable
fun NowPreview() {
    Now()
}