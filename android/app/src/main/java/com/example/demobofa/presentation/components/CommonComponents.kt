package com.example.demobofa.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun EricaSearchBar(
    modifier: Modifier = Modifier,
    onEricaClick: () -> Unit = {}
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .height(50.dp),
        shape = RoundedCornerShape(25.dp),
        color = Color.White,
        shadowElevation = 2.dp
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search",
                tint = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Hi, I'm Erica. May I help?",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Gray,
                modifier = Modifier.weight(1f)
            )
            // Erica Badge placeholder
             Box(
                 contentAlignment = Alignment.TopEnd
             ) {
                 Icon(
                     imageVector = Icons.Default.Search, // Placeholder for Erica icon
                     contentDescription = "Erica",
                     tint = MaterialTheme.colorScheme.secondary
                 )
                 Badge(containerColor = MaterialTheme.colorScheme.secondary) {
                     Text("3", color = Color.White, fontSize = 10.sp)
                 }
             }
        }
    }
}

@Composable
fun FlagscapeLogo(modifier: Modifier = Modifier) {
    // Quick textual simulation or Icon
    Row(modifier = modifier, horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
        Box(modifier = Modifier.width(8.dp).height(24.dp).background(MaterialTheme.colorScheme.primary))
        Spacer(modifier = Modifier.width(4.dp))
        Box(modifier = Modifier.width(8.dp).height(24.dp).background(MaterialTheme.colorScheme.secondary))
        Spacer(modifier = Modifier.width(4.dp))
        Box(modifier = Modifier.width(8.dp).height(24.dp).background(MaterialTheme.colorScheme.secondary))
    }
}

@Composable
fun PrimaryButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {
    Button(
        onClick = onClick,
        modifier = modifier.fillMaxWidth().height(48.dp),
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary
        ),
        enabled = enabled
    ) {
        Text(text, fontWeight = FontWeight.Bold, fontSize = 16.sp)
    }
}