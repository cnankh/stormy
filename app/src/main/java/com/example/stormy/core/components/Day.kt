package com.example.stormy.core.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.stormy.R
import com.example.stormy.feature.forecast.model.Day


@Composable
fun Day(modifier: Modifier = Modifier, day: Day = Day()) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp)
            .padding(horizontal = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Image(
            modifier = Modifier.size(50.dp),
            painter = painterResource(id = R.drawable.ic_sunny),
            contentDescription = "condition icon"
        )

        Column(modifier = Modifier) {
            Text(
                text = "Monday",
                style = MaterialTheme.typography.bodyMedium.copy(color = Color.Black)
            )
            Text(
                text = "April 12th",
                style = MaterialTheme.typography.bodyMedium.copy(color = Color.Gray)
            )
        }

        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "${day.minTempC.toInt()}",
            style = MaterialTheme.typography.headlineSmall.copy(color = Color.Gray)
        )

        Text(
            text = "${day.maxTempC.toInt()}",
            style = MaterialTheme.typography.headlineSmall.copy(color = Color.Black)
        )

    }

}

@Preview(showBackground = true)
@Composable
private fun DayPreview() {
    Day()
}