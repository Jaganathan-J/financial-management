package com.example.demobofa.presentation.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.demobofa.domain.model.Account
import com.example.demobofa.domain.model.DashboardWidget
import com.example.demobofa.domain.repository.AccountRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val repository: AccountRepository
) : ViewModel() {

    val accounts = repository.getAccounts()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    val widgets = repository.getDashboardWidgets()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

}