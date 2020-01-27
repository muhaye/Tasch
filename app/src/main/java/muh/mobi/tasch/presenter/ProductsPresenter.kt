package muh.mobi.tasch.presenter

import android.content.Context
import androidx.databinding.ObservableField
import android.view.View
import muh.mobi.tasch.ProductManager
import muh.mobi.tasch.model.Product

data class ProductsPresenter(val context: Context,
                             val regToken: String,
                             val onProductRetrieved: ( Array<Product>)-> Unit,
                             val onShowContactCenter: ()-> Unit) {

    var title = ObservableField<String>()
    var spinnerVisibility = ObservableField(View.VISIBLE)
    var onClickClose:(()-> Unit)?=null

    init {

        ProductManager().getProducts { products ->

            if (products.isNotEmpty()) {
                spinnerVisibility.set(View.GONE)
                onProductRetrieved(products)
            }
        }
    }


    fun onClickShowContactCenter() {
        onShowContactCenter()
    }

}