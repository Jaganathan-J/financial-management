package com.example.demobofa.data.repository

import com.example.demobofa.domain.model.*
import com.example.demobofa.domain.repository.AccountRepository
import com.example.demobofa.domain.repository.AuthRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class MockRepositoryImpl : AuthRepository, AccountRepository {

    override suspend fun login(userId: String, password: String): Result<User> {
        delay(1500)
        return if (userId.isNotEmpty() && password.isNotEmpty()) {
            Result.success(User("u1", "Jaganathan", "jagan****"))
        } else {
            Result.failure(Exception("Invalid credentials"))
        }
    }

    override fun getAccounts(): Flow<List<Account>> = flow {
        delay(500)
        emit(listOf(
            Account("1", "Adv Plus Banking", "0688", "$1,608.03", AccountType.CHECKING, true),
            Account("2", "Customized Cash Rewards Visa Signature", "0012", "$11,576.90", AccountType.CREDIT),
            Account("3", "Customized Cash Rewards World Mastercard", "5069", "$6,446.27", AccountType.CREDIT)
        ))
    }

    override fun getDashboardWidgets(): Flow<List<DashboardWidget>> = flow {
        delay(500)
        emit(listOf(
            DashboardWidget("w1", "On Average You Spend", "$4,691", "Less Than You Deposit", "chart"),
            DashboardWidget("w2", "My FICO® Score", "769", "As of 11/19/2025", "fico"),
            DashboardWidget("w3", "BankAmeriDeals®", "Up to 30%", "41 days left", "deal"),
            DashboardWidget("w4", "Alerts", "0", "Unread", "bell"),
            DashboardWidget("w5", "My Rewards", "$463.07", "Total Reward Value", "star")
        ))
    }
}