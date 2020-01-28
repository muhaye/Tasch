package muh.mobi.tasch.adapter

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_product_item.view.*
import kotlinx.android.synthetic.main.fragment_wish.view.*
import muh.mobi.tasch.R

import muh.mobi.tasch.model.Product
import muh.mobi.tasch.model.Wish

/**
 * [RecyclerView.Adapter] that can display a [DummyItem] and makes a call to the
 * specified [OnListFragmentInteractionListener].
 * TODO: Replace the implementation with code for your data type.
 */

class WishListRecyclerViewAdapter(
        val wishes: Array<Wish>,
        val onItemSelected: (Wish) -> Unit)
    : RecyclerView.Adapter<WishListRecyclerViewAdapter.ViewHolder>() {

    private val mOnClickListener: View.OnClickListener

    init {
        mOnClickListener = View.OnClickListener { v ->
            val item = v.tag as Wish
            // Notify the active callbacks interface (the activity, if the fragment is attached to
            // one) that an item has been selected.
            onItemSelected(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_wish, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = wishes[position]
        holder.mContentView.text = item.product.description

        with(holder.mView) {
            tag = item
            setOnClickListener(mOnClickListener)
        }
    }

    override fun getItemCount(): Int = wishes.size

    inner class ViewHolder(val mView: View): RecyclerView.ViewHolder(mView) {
        val mContentView: TextView = mView.wish_item

        override fun toString(): String {
            return super.toString() + " '" + mContentView.text + "'"
        }
    }
}
