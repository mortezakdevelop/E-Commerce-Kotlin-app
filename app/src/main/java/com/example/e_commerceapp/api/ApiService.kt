package com.example.e_commerceapp.api

import com.example.e_commerceapp.model.network.ProductNetwork
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("products")
    suspend fun getAllProducts():Response<List<ProductNetwork>>
}