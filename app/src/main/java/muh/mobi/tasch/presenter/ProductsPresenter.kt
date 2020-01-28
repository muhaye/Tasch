package muh.mobi.tasch.presenter

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import androidx.databinding.ObservableField
import android.view.View
import android.widget.Adapter
import androidx.recyclerview.widget.RecyclerView
import muh.mobi.tasch.ProductManager
import muh.mobi.tasch.adapter.ProductsRecyclerViewAdapter
import muh.mobi.tasch.model.Product
import muh.mobi.tasch.model.Store
import muh.mobi.tasch.model.Wish

data class ProductsPresenter(val onProductsRetrieved:(products: Array<Product>) -> Unit,
                             val onWishListRetrieved:(products: Array<Product>) -> Unit,
                             private val productManager: ProductManager = ProductManager()) {


    var total = ObservableField<Double>()
    var subTotalText = ObservableField<SpannableStringBuilder>()
        get() {
            val label = "Sub-Total"
            val sb = SpannableStringBuilder(label)

            sb.append(" $${ String.format("%.2f", total.get()) }")
            sb.setSpan(StyleSpan(Typeface.BOLD),0, label.length, Spannable.SPAN_INCLUSIVE_INCLUSIVE)
            return ObservableField(sb)
        }



    fun loadProducts() {

        productManager.getProducts { products ->

            if (products.isNotEmpty()) {
                onProductsRetrieved(products)
            }
        }
    }

    fun loadWithList() {

        Store.wishlist?.let { wishes ->

            total.set( wishes.sumByDouble { it.price } )

            subTotalText.notifyChange()

            onWishListRetrieved(wishes.toTypedArray())
        }
    }

}