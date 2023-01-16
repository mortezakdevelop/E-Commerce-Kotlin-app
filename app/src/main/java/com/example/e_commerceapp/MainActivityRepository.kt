package com.example.e_commerceapp

import com.example.e_commerceapp.hilt.api.ApiService
import com.example.e_commerceapp.model.domain.Product
import com.example.e_commerceapp.model.mapper.ProductMapper
import javax.inject.Inject

class MainActivityRepository @Inject constructor(
    private val apiService: ApiService,
    private val productMapper: ProductMapper
){
    suspend fun fetchAllProducts():List<Product>{
        return apiService.getAllProducts().body()?.let { productNetworks ->
            productNetworks.map {
                productMapper.buildFrom(it)
            }
        }?: emptyList()
    }
}