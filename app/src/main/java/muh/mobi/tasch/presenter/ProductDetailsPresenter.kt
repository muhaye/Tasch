package muh.mobi.tasch.presenter

import androidx.databinding.ObservableField
import muh.mobi.tasch.ProductManager
import muh.mobi.tasch.model.Product
import muh.mobi.tasch.model.Store


data class ProductDetailsPresenter(private val productManager: ProductManager = ProductManager()) {

    val isInWishList = ObservableField<Boolean>(false)
    var product: Product? = null

    fun onProduct(product: Product) {
        this.product = product
        isInWishList?.set(Store.wishlist.contains(product))
    }
}