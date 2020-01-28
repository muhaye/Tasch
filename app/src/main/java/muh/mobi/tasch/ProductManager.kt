package muh.mobi.tasch

import muh.mobi.tasch.model.Color
import muh.mobi.tasch.model.Product
import muh.mobi.tasch.model.Size
import muh.mobi.tasch.model.Wish

class ProductManager {

    val products = Array(30) {
        Product("d",
            "FooTitle",
            "url",
            "",
            Array(2, { Color("23,23,23") } ) ,
            Size(2,2,2),
            24.99,
            3)
    }

    fun getProducts(onProductsRetrieved: ( products: Array<Product>)-> Unit) {

        onProductsRetrieved(products)
    }

    val wishes = Array(size = 4) {
        Wish( "foo", products.first())
    }
}


