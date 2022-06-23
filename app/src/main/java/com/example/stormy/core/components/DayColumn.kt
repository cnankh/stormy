package com.example.stormy.core.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.stormy.feature.forecast.model.ForecastDay

@Composable
fun DayColumn(
    modifier: Modifier = Modifier,
    content: List<ForecastDay> = emptyList()
) {

    LazyColumn(
        modifier = modifier
            .background(
                MaterialTheme.colorScheme.background,
                RoundedCornerShape(10.dp)
            ), verticalArrangement = Arrangement.spacedBy(32.dp),
        contentPadding = PaddingValues(10.dp)
    ) {
        items(content) {
            Day(day = it.day)
        }
    }

}

@Preview(showBackground = true)
@Composable
private fun DayColumnPreview() {
    DayColumn()
}