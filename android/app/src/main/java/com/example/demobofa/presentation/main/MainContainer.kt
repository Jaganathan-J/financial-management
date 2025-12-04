package com.example.demobofa.presentation.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.example.demobofa.presentation.components.EricaSearchBar
import com.example.demobofa.presentation.dashboard.DashboardScreen
import com.example.demobofa.presentation.deposit.DepositCheckScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainContainerScreen(
    onMenuClick: () -> Unit,
    onLogOut: () -> Unit
) {
    var currentTab by remember { mutableIntStateOf(0) }

    Scaffold(
        topBar = {
            Column {
                // Custom Top Bar
                CenterAlignedTopAppBar(
                     navigationIcon = {
                         IconButton(onClick = onMenuClick) {
                             Icon(Icons.Default.Menu, "Menu")
                         }
                     },
                     title = {},
                     actions = {
                         IconButton(onClick = {}) { 
                             BadgedBox(badge = { Badge { Text("1") } }) {
                                 Icon(Icons.Default.Mail, "Inbox") 
                             }
                         }
                         IconButton(onClick = {}) { Icon(Icons.Default.Star, "Products") }
                         IconButton(onClick = onLogOut) { Icon(Icons.AutoMirrored.Filled.ExitToApp, "Log Out") }
                     }
                )
                EricaSearchBar(modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp))
            }
        },
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    selected = currentTab == 0,
                    onClick = { currentTab = 0 },
                    icon = { Icon(Icons.Default.AccountCircle, "Accounts") },
                    label = { Text("Accounts") }
                )
                NavigationBarItem(
                    selected = currentTab == 1,
                    onClick = { currentTab = 1 },
                    icon = { Icon(Icons.Default.SwapHoriz, "Pay & Transfer") },
                    label = { Text("Pay & Transfer") }
                )
                NavigationBarItem(
                    selected = currentTab == 2,
                    onClick = { currentTab = 2 },
                    icon = { Icon(Icons.Default.CameraAlt, "Deposit Checks") },
                    label = { Text("Deposit Checks") }
                )
                NavigationBarItem(
                    selected = currentTab == 3,
                    onClick = { currentTab = 3 },
                    icon = { Icon(Icons.Default.PieChart, "Invest") },
                    label = { Text("Invest") }
                )
            }
        }
    ) { padding ->
        Box(modifier = Modifier.padding(padding)) {
            when (currentTab) {
                0 -> DashboardScreen()
                2 -> DepositCheckScreen()
                else -> Text("Feature coming soon!", modifier = Modifier.padding(16.dp))
            }
        }
    }
}