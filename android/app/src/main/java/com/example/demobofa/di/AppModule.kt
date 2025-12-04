package com.example.demobofa.di

import com.example.demobofa.data.repository.MockRepositoryImpl
import com.example.demobofa.domain.repository.AuthRepository
import com.example.demobofa.domain.repository.AccountRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideAuthRepository(): AuthRepository = MockRepositoryImpl()

    @Provides
    @Singleton
    fun provideAccountRepository(): AccountRepository = MockRepositoryImpl()
}