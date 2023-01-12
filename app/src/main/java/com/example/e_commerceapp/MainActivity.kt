package com.example.e_commerceapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.e_commerceapp.databinding.ActivityMainBinding
import com.example.e_commerceapp.api.ApiService
import com.example.e_commerceapp.epoxy.ProductEpoxyController
import com.example.e_commerceapp.model.domain.Product
import com.example.e_commerceapp.model.mapper.ProductMapper
import com.example.e_commerceapp.model.network.ProductNetwork
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Response
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var activityMainBinding: ActivityMainBinding

    @Inject
    lateinit var apiService: ApiService

    @Inject
    lateinit var productMapper: ProductMapper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        val controller = ProductEpoxyController()
        activityMainBinding.epoxyRecyclerView.setController(controller)
        controller.setData(emptyList())

        lifecycleScope.launchWhenStarted {
            val response:Response<List<ProductNetwork>> = apiService.getAllProducts()
            val domainProduct:List<Product> = response.body()!!.map {
                productMapper.buildFrom(it)
            }
            controller.setData(domainProduct)

            if(domainProduct.isEmpty()){
                Snackbar.make(activityMainBinding.root,"data not fetch",Snackbar.LENGTH_LONG).show()
            }
        }
    }


//    private fun setupListeners() {
//        activityMainBinding.cardView.setOnClickListener {
//            activityMainBinding.productDescriptionTextView.apply {
//                isVisible = !isVisible
//            }
//        }
//
//        activityMainBinding.addToCartButton.setOnClickListener {
//            activityMainBinding.inCartView.apply {
//                isVisible = !isVisible
//            }
//        }
//
//        var isFavorite = false
//        activityMainBinding.favoriteImageView.setOnClickListener {
//            val imageRes = if (isFavorite) {
//                R.drawable.ic_baseline_favorite_24
//            } else {
//                R.drawable.ic_baseline_favorite_border_24
//            }
//
//            activityMainBinding.favoriteImageView.setIconResource(imageRes)
//            isFavorite = !isFavorite
//        }
//
//    }
}