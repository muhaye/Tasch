package muh.mobi.tasch.model

import android.graphics.Color
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import kotlinx.serialization.Serializable


@Serializable
data class Product(val title: String,
                   val image: String,
                   val description: String,
                   val colors:  Array<AvailableColor>,
                   val size: Size,
                   val price: Double,
                   val Quantity: Int) {

    fun stockAvailablity(): SpannableStringBuilder {

        val sb: SpannableStringBuilder
        if (colors.isEmpty() ) {
            sb = SpannableStringBuilder("Out of stock")
            val fcs = ForegroundColorSpan(Color.rgb(255, 0, 0))
            sb.setSpan(fcs, 0, sb.length , Spannable.SPAN_INCLUSIVE_INCLUSIVE)

        } else {

            var strRaw = Array(colors.size) { "\u25A0" }
            sb = SpannableStringBuilder(strRaw.joinToString(""))

            colors.forEachIndexed { i, c ->
                val fcs = ForegroundColorSpan(Color.rgb(c.r, c.g, c.b))
                sb.setSpan(fcs, i, i + 1, Spannable.SPAN_INCLUSIVE_INCLUSIVE)
            }
        }

        return sb

    }

    fun sizeDescription(): String {
        return "H:${size.height}cm\nW:${size.width}cm\nD:${size.depth}cm\n"
    }

}




@Serializable
data class Wish(val id: String,
                val product: Product)

@Serializable
data class Size (val height: Int,
                 val width: Int,
                 val depth: Int)

@Serializable
data class AvailableColor(val r: Int, val g: Int, val b: Int)

