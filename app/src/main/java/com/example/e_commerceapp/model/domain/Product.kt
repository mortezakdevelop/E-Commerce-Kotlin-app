package com.example.e_commerceapp.model.domain

import com.example.e_commerceapp.model.network.Rating
import java.math.BigDecimal

data class Product(
    val category: String,
    val description: String,
    val id: Int,
    val image: String,
    val price: BigDecimal,
    val rating: Rating,
    val title: String
)
