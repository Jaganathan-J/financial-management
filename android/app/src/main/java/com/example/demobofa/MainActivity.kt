package com.example.demobofa

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import dagger.hilt.android.AndroidEntryPoint
import com.example.demobofa.presentation.theme.DemoBofaTheme
import com.example.demobofa.presentation.navigation.AppNavGraph

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DemoBofaTheme {
                AppNavGraph()
            }
        }
    }
}