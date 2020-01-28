package muh.mobi.tasch.presenter

import android.content.Context
import androidx.databinding.ObservableField
import android.view.View
import android.widget.Adapter
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import muh.mobi.tasch.ProductManager
import muh.mobi.tasch.R
import muh.mobi.tasch.adapter.ProductsRecyclerViewAdapter
import muh.mobi.tasch.model.Product
import muh.mobi.tasch.model.Wish

data class ProductDetailsPresenter(private val productManager: ProductManager = ProductManager()) {

    var imageUrl = ObservableField<String>()
    var title = ObservableField<String>()

    init {

//        Picasso
//            .get()
//            .load(product.image)
//            .placeholder(R.drawable.producr_placeholder)
//            .into(imageView.get())


        //onProduct =
    }

    fun onProduct(product: Product) {
        title.set(product.title)
    }

}