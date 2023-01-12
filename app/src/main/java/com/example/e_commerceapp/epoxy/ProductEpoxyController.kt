package com.example.e_commerceapp.epoxy

import com.airbnb.epoxy.TypedEpoxyController
import com.example.e_commerceapp.epoxy.models.ProductEpoxyModel
import com.example.e_commerceapp.model.domain.Product

class ProductEpoxyController: TypedEpoxyController<List<Product>>() {
    override fun buildModels(data: List<Product>?) {

        if (data.isNullOrEmpty()){
            //is loading state
            repeat(7){ id ->
                val epoxyId = id + 1
                ProductEpoxyModel(product = null).id(epoxyId).addTo(this)
            }
            return
        }

        data.forEach { product ->
            ProductEpoxyModel(product).id(product.id).addTo(this)
        }
    }
}