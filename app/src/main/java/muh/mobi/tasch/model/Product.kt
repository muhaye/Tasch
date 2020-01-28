package muh.mobi.tasch.model
import kotlinx.serialization.*

@Serializable
data class Product(val id: String,
                   val title: String,
                   val image: String,
                   val description: String,
                   val colors: Array<Color>,
                   val size: Size,
                   val price: Double,
                   val Quantity: Int)

@Serializable
data class Wish(val id: String,
                val product: Product)

@Serializable
data class Size (val height: Int,
                 val Width: Int,
                 val Depth: Int)

@Serializable
data class Color (val rbg: String)

