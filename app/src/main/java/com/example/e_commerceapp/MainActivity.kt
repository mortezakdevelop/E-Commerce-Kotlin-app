package com.example.e_commerceapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.lifecycleScope
import com.example.e_commerceapp.databinding.ActivityMainBinding
import com.example.e_commerceapp.hilt.api.ApiService
import com.example.e_commerceapp.epoxy.ProductEpoxyController
import com.example.e_commerceapp.model.domain.Product
import com.example.e_commerceapp.model.mapper.ProductMapper
import com.example.e_commerceapp.model.network.ProductNetwork
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import retrofit2.Response
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var activityMainBinding: ActivityMainBinding


    private val viewModel:MainActivityViewModel by lazy {
        ViewModelProvider(this)[MainActivityViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        val controller = ProductEpoxyController()
        activityMainBinding.epoxyRecyclerView.setController(controller)
        controller.setData(emptyList())

        viewModel.store.stateFlow.map {
            it.products
        }.distinctUntilChanged().asLiveData().observe(this){product ->

            controller.setData(product)

//            if(product.isEmpty()){
//                Snackbar.make(activityMainBinding.root,"data not fetch",Snackbar.LENGTH_LONG).show()
//            }
        }
       viewModel.refreshData()
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