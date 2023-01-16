package com.example.e_commerceapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.e_commerceapp.model.domain.Product
import com.example.e_commerceapp.redux.ApplicationState
import com.example.e_commerceapp.redux.Store
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    val store: Store<ApplicationState>,
    private val mainActivityRepository:MainActivityRepository
):ViewModel() {


    fun refreshData() = viewModelScope.launch {
        val products:List<Product> = mainActivityRepository.fetchAllProducts()
        store.update { applicationState ->
            return@update applicationState.copy(
                products = products
            )
        }
    }
}