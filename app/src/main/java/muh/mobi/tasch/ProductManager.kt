package muh.mobi.tasch

import muh.mobi.tasch.model.AvailableColor
import muh.mobi.tasch.model.Product
import muh.mobi.tasch.model.Size
import muh.mobi.tasch.model.Store

class ProductManager {

    fun getProducts(onProductsRetrieved: ( products: Array<Product>)-> Unit) {

        val products = Store.products
        onProductsRetrieved(products)
    }

    //val wishes = products.take(4)

}


