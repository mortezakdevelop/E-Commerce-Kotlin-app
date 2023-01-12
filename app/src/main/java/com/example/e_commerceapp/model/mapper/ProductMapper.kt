package com.example.e_commerceapp.model.mapper

import com.example.e_commerceapp.model.domain.Product
import com.example.e_commerceapp.model.network.ProductNetwork
import java.math.BigDecimal
import java.math.RoundingMode
import javax.inject.Inject

class ProductMapper @Inject constructor() {
    fun buildFrom(productNetwork: ProductNetwork):Product{
        return Product(
            category = productNetwork.category,
            description = productNetwork.description,
            id = productNetwork.id,
            image = productNetwork.image,
            price = BigDecimal(productNetwork.price).setScale(2,RoundingMode.HALF_UP),
            rating = productNetwork.rating,
            title = productNetwork.title
        )
    }
}