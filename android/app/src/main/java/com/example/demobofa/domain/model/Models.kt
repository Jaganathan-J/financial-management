package com.example.demobofa.domain.model

data class User(
    val id: String,
    val name: String,
    val maskedId: String
)

data class Account(
    val id: String,
    val name: String,
    val mask: String,
    val balance: String,
    val type: AccountType,
    val isFdicInsured: Boolean = false
)

enum class AccountType {
    CHECKING, CREDIT, SAVINGS, INVESTMENT
}

data class DashboardWidget(
    val id: String,
    val title: String,
    val value: String,
    val subtitle: String? = null,
    val iconName: String // identifier for icon
)