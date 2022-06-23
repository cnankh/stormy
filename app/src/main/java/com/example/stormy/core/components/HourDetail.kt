package com.example.stormy.core.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.stormy.R

@Composable
fun HourDetail(
    modifier: Modifier = Modifier,
    time: String = "",
    temperature: String = "",
    icon: String = "",
) {

    Column(
        modifier = modifier
            .padding(vertical = 6.dp)
            .padding(horizontal = 8.dp)
            .width(40.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {

        Text(text = time, style = MaterialTheme.typography.labelMedium.copy(color = Color.Black))

        Image(
            modifier = Modifier.size(20.dp),
            painter = painterResource(id = R.drawable.ic_sunny),
            contentDescription = "condition icon"
        )

        Text(
            text = "$temperature°",
            style = MaterialTheme.typography.labelMedium.copy(color = Color.Black)
        )

    }


}

@Preview(showBackground = true)
@Composable
private fun HourDetailPreview() {
    HourDetail()
}