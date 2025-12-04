package com.example.demobofa.presentation.deposit

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.demobofa.presentation.components.PrimaryButton

@Composable
fun DepositCheckScreen() {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(scrollState)
            .padding(16.dp)
    ) {
        Text(
            "Legal info and disclosures",
            style = MaterialTheme.typography.labelLarge,
            color = MaterialTheme.colorScheme.primary
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            "Sign and write 'for deposit only at Bank of America' on back.",
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(modifier = Modifier.height(24.dp))

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            CameraBox("Front of Check", Modifier.weight(1f))
            CameraBox("Back of Check", Modifier.weight(1f))
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Forms
        Text("Deposit to", fontWeight = FontWeight.Bold)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp)
                .border(1.dp, Color.LightGray, RoundedCornerShape(4.dp))
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Select account", color = Color.Gray)
            Icon(Icons.AutoMirrored.Filled.ArrowForwardIos, null, modifier = Modifier.size(16.dp))
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text("Enter amount", fontWeight = FontWeight.Bold)
        OutlinedTextField(
            value = "",
            onValueChange = {},
            placeholder = { Text("$0.00") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(32.dp))

        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            OutlinedButton(
                onClick = {}, 
                modifier = Modifier.weight(1f)
            ) {
                Text("CANCEL")
            }
            Button(
                onClick = {}, 
                modifier = Modifier.weight(1f),
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
            ) {
                Text("NEXT")
            }
        }
        
        Spacer(modifier = Modifier.height(100.dp))
    }
}

@Composable
fun CameraBox(label: String, modifier: Modifier) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .background(Color(0xFFF0F0F0), RoundedCornerShape(8.dp))
                .clickable { },
            contentAlignment = Alignment.Center
        ) {
            Icon(Icons.Default.CameraAlt, null, tint = Color.Gray)
        }
        Text(label, style = MaterialTheme.typography.bodySmall, modifier = Modifier.padding(top = 4.dp))
    }
}