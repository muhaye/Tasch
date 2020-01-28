package muh.mobi.tasch.fragment


import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_products_list.*
import muh.mobi.tasch.R
import muh.mobi.tasch.adapter.ProductsRecyclerViewAdapter
import muh.mobi.tasch.databinding.FragmentProductPreviewBinding
import muh.mobi.tasch.databinding.FragmentProductWishBinding
import muh.mobi.tasch.model.Product
import muh.mobi.tasch.model.Store
import muh.mobi.tasch.presenter.ProductsPresenter

class ProductsFragment: Fragment() {

    companion object {
        fun newInstance() = ProductsFragment()
    }

    val productDetailFragment by lazy  { ProductDetailFragment()}

    private val productsPresenter by lazy {
        ProductsPresenter(::populateProduct, ::populateWishList)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        val binding: muh.mobi.tasch.databinding.FragmentProductsListBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_products_list, container, false)
        val view = binding.root

        binding.presenter = productsPresenter

        return view
    }

    fun populateProduct(products: Array<Product>) {

        val horizontalLayoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)

        var recyclerView = view?.findViewById<RecyclerView>(R.id.list)

        recyclerView?.layoutManager = horizontalLayoutManager

        // Set the adapter
        if (recyclerView is RecyclerView) {
            with(recyclerView) {
                adapter = ProductsRecyclerViewAdapter<FragmentProductPreviewBinding>(
                    R.layout.fragment_product_preview,
                    products, ::showDetails)
            }
        }
    }

    fun populateWishList(wishes: Array<Product>) {

        val recyclerView = view?.findViewById<View>(R.id.whish_list)

        // Set the adapter
        if (recyclerView is RecyclerView) {
            with(recyclerView) {

                adapter = ProductsRecyclerViewAdapter<FragmentProductWishBinding>(
                    R.layout.fragment_product_wish,
                    wishes, ::showDetails)
            }
        }
    }

    override fun onResume() {
        super.onResume()

        productsPresenter.loadProducts()
        productsPresenter.loadWithList()

        checkoutButton?.setOnClickListener {

            val builder = AlertDialog.Builder(context)

            builder.setMessage(getString(R.string.are_sure))

            builder.setPositiveButton(
                "YES"
            ) { dialog, which ->

                Store.wishlist = mutableSetOf()
                productsPresenter.loadWithList()

                dialog.dismiss()
            }

            builder.setNegativeButton(
                "NO"
            ) { dialog, which ->
                // Do nothing
                dialog.dismiss()
            }

            val alert = builder.create()
            alert.show()
        }
    }


    fun showDetails(product: Product) {

        activity
            ?.supportFragmentManager
            ?.beginTransaction()
            ?.replace(R.id.container, productDetailFragment, "productDetailFragment")
            ?.addToBackStack(null)
            ?.commit()

        productDetailFragment.onProduct(product)
    }
}