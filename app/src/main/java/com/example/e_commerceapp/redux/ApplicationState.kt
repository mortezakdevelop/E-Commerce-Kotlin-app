package com.example.e_commerceapp.redux

import com.example.e_commerceapp.model.domain.Product

data class ApplicationState(
    val products: List<Product> = emptyList()
)
