package com.example.stormy.core.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun NowDetail(
    modifier: Modifier = Modifier,
    label: String = "Wind",
    value: String = "56 km/h"
) {

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(6.dp)
    ) {

        Text(text = label)
        Text(text = value)

    }

}

@Preview(showBackground = true)
@Composable
fun NowDetailPreview() {
    NowDetail()
}