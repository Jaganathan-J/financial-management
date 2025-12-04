package com.example.demobofa.domain.repository

import com.example.demobofa.domain.model.Account
import com.example.demobofa.domain.model.DashboardWidget
import com.example.demobofa.domain.model.User
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    suspend fun login(userId: String, password: String): Result<User>
}

interface AccountRepository {
    fun getAccounts(): Flow<List<Account>>
    fun getDashboardWidgets(): Flow<List<DashboardWidget>>
}