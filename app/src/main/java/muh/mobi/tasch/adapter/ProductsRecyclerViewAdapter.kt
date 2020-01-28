package muh.mobi.tasch.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import muh.mobi.tasch.R
import muh.mobi.tasch.databinding.FragmentProductPreviewBinding
import muh.mobi.tasch.databinding.FragmentProductWishBinding
import muh.mobi.tasch.model.Product


class ProductViewHolder<T: ViewDataBinding>(binding: T): RecyclerView.ViewHolder(binding.getRoot()) {

    private val binding: T
    fun bind(product: Product?) {

        if (binding is FragmentProductPreviewBinding )
             binding.product = product

        if (binding is FragmentProductWishBinding )
            binding.product = product

        binding.executePendingBindings()
    }

    init {
        this.binding = binding
    }
}

class ProductsRecyclerViewAdapter<T: ViewDataBinding>(
    val layoutItemRes: Int = R.layout.fragment_product_preview,
    val products: Array<Product>,
    val onItemSelected: (Product) -> Unit)
    : RecyclerView.Adapter<ProductViewHolder<T>>() {

    private val mOnClickListener: View.OnClickListener

    init {
        mOnClickListener = View.OnClickListener { v ->
            val item = v.tag as Product
            // Notify the active callbacks interface (the activity, if the fragment is attached to
            // one) that an item has been selected.
            onItemSelected(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder<T> {

        val inflater = LayoutInflater.from(parent.getContext())
        // Inflate the layout for this fragment
        val binding: T = DataBindingUtil.inflate(
            inflater, layoutItemRes, parent, false)
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder<T>, position: Int) {
        val item = products[position]

        holder.bind(item)

        with(holder.itemView) {
            tag = item
            setOnClickListener(mOnClickListener)
        }
    }

    override fun getItemCount(): Int = products.size


}
