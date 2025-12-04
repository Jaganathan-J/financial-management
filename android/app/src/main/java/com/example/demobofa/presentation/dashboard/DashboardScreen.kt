package com.example.demobofa.presentation.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.demobofa.domain.model.Account
import com.example.demobofa.domain.model.AccountType
import com.example.demobofa.presentation.theme.LightGray

@Composable
fun DashboardScreen(
    viewModel: DashboardViewModel = hiltViewModel()
) {
    var selectedTab by remember { mutableIntStateOf(0) } // 0 = ACCOUNTS, 1 = DASHBOARD
    val accounts by viewModel.accounts.collectAsState()
    val widgets by viewModel.widgets.collectAsState()

    Column(modifier = Modifier.fillMaxSize()) {
        // Top Tabs
        TabRow(
            selectedTabIndex = selectedTab,
            containerColor = Color.White,
            contentColor = MaterialTheme.colorScheme.primary
        ) {
            Tab(
                selected = selectedTab == 0,
                onClick = { selectedTab = 0 },
                text = { Text("ACCOUNTS", fontWeight = FontWeight.Bold) }
            )
            Tab(
                selected = selectedTab == 1,
                onClick = { selectedTab = 1 },
                text = { Text("DASHBOARD", fontWeight = FontWeight.Bold) }
            )
        }

        if (selectedTab == 0) {
            AccountsView(accounts)
        } else {
            DashboardWidgetsView(widgets)
        }
    }
}

@Composable
fun AccountsView(accounts: List<Account>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentPadding = PaddingValues(16.dp)
    ) {
        item {
            Text(
                "Hello, Jaganathan",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }

        val banking = accounts.filter { it.type == AccountType.CHECKING || it.type == AccountType.SAVINGS }
        item {
            SectionHeader("Banking")
        }
        items(banking) { acc ->
            AccountRow(acc)
        }

        val credit = accounts.filter { it.type == AccountType.CREDIT }
        if (credit.isNotEmpty()) {
            item {
                Spacer(modifier = Modifier.height(16.dp))
                SectionHeader("Credit cards")
            }
            items(credit) { acc ->
                AccountRow(acc)
            }
        }
    }
}

@Composable
fun SectionHeader(title: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(LightGray)
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(title, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun AccountRow(account: Account) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(account.name, fontWeight = FontWeight.SemiBold)
                if (account.isFdicInsured) {
                    Text("Member FDIC", style = MaterialTheme.typography.bodySmall, color = Color.Gray)
                }
                Text("...${account.mask}", color = Color.Gray)
            }
            Column(horizontalAlignment = Alignment.End) {
                Text(account.balance, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowForwardIos,
                    contentDescription = null,
                    modifier = Modifier.size(14.dp),
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        }
        HorizontalDivider()
    }
}

@Composable
fun DashboardWidgetsView(widgets: List<com.example.demobofa.domain.model.DashboardWidget>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(8.dp),
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(widgets) { widget ->
            Card(
                colors = CardDefaults.cardColors(containerColor = Color.White),
                modifier = Modifier.height(160.dp)
            ) {
                Column(
                    modifier = Modifier.padding(12.dp),
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(widget.title, style = MaterialTheme.typography.labelLarge)
                    Spacer(modifier = Modifier.weight(1f))
                    Text(widget.value, style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.Bold)
                    widget.subtitle?.let {
                        Text(it, style = MaterialTheme.typography.labelSmall, color = Color.Gray)
                    }
                }
            }
        }
    }
}