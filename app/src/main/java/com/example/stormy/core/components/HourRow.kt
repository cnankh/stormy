package com.example.stormy.core.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.stormy.feature.forecast.model.Hour

@Composable
fun HourRow(
    modifier: Modifier = Modifier,
    content: List<Hour> = listOf()
) {
    LazyRow(
        modifier = Modifier
            .background(
                MaterialTheme.colorScheme.background,
                RoundedCornerShape(10.dp)
            ), horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(10.dp)
    ) {
        items(content) {
            HourDetail(
                time = it.time,
                icon = it.condition.icon,
                temperature = "${it.tempC.toInt()}"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HourRowPreview() {
    HourRow()
}