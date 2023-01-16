package com.example.e_commerceapp.hilt.module

import com.example.e_commerceapp.redux.ApplicationState
import com.example.e_commerceapp.redux.Store
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApplicationStateModule {

    @Provides
    @Singleton
    fun provideApplicationStateStore():Store<ApplicationState>{
        return Store(ApplicationState())
    }
}