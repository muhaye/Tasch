package muh.mobi.tasch.model
import kotlinx.serialization.*

@Serializable
data class Product(val id: String,
                   val image: String,
                   val description: String,
                   val colors: List<Color>,
                   val size: Size,
                   val price: Double,
                   val Quantity: Int)

@Serializable
data class Size (val id: String,
                 val height: Int,
                 val Width: Int,
                 val Depth: Int)

@Serializable
data class Color (val rbg: String)

