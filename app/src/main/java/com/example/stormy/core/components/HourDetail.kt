package com.example.stormy.core.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.stormy.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HourDetail(
    modifier: Modifier = Modifier,
    time: String = "",
    temperature: String = "",
    icon: String = "",
) {

    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.secondary, RoundedCornerShape(10.dp))
            .padding(vertical = 6.dp)
            .padding(horizontal = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {

        Text(text = "22:00", style = MaterialTheme.typography.labelMedium)

        Image(
            modifier = Modifier.size(20.dp),
            painter = painterResource(id = R.drawable.ic_sunny),
            contentDescription = "condition icon"
        )

        Text(text = "$temperature °", style = MaterialTheme.typography.labelMedium)

    }


}

@Preview(showBackground = true)
@Composable
fun HourDetailPreview() {
    HourDetail()
}