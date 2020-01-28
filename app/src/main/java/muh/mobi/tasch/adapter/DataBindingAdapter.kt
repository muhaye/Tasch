package muh.mobi.tasch.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import muh.mobi.tasch.R

val picasso by lazy { Picasso.get() }

class DataBindingAdapter {

    companion object {

        @BindingAdapter("bind:imageUrl")
        @JvmStatic
        fun loadImage(imageView: ImageView, imageUrl: String) {

            picasso.load(imageUrl)
                .placeholder(R.drawable.producr_placeholder)
                .error(R.drawable.placeholder_error)
                .into(imageView)
        }
    }
}