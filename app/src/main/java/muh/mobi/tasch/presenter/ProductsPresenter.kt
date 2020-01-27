package muh.mobi.tasch.presenter

import android.content.Context
import androidx.databinding.ObservableField
import android.view.View
import android.widget.Adapter
import androidx.recyclerview.widget.RecyclerView
import muh.mobi.tasch.ProductManager
import muh.mobi.tasch.adapter.ProductsRecyclerViewAdapter
import muh.mobi.tasch.model.Product
import muh.mobi.tasch.model.Wish

data class ProductsPresenter(val onProductsRetrieved:(products: Array<Product>) -> Unit,
                             val onWishListRetrieved:(products: Array<Wish>) -> Unit,
                             private val productManager: ProductManager = ProductManager()) {


    var title = ObservableField<String>()
    var spinnerVisibility = ObservableField(View.VISIBLE)

//    init {
//
//
//    }
//

    fun loadProducts() {

        productManager.getProducts { products ->

            if (products.isNotEmpty()) {
                spinnerVisibility.set(View.GONE)
                onProductsRetrieved(products)
            }
        }
    }


    fun loadWithList() {

        productManager.wishes?.let { wishes ->

            if (wishes.isNotEmpty()) {
                spinnerVisibility.set(View.GONE)
                onWishListRetrieved(wishes)
            }
        }

    }

}