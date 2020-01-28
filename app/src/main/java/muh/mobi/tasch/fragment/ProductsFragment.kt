package muh.mobi.tasch.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import muh.mobi.tasch.R
import muh.mobi.tasch.adapter.ProductsRecyclerViewAdapter
import muh.mobi.tasch.adapter.WishListRecyclerViewAdapter
import muh.mobi.tasch.model.Product
import muh.mobi.tasch.model.Wish
import muh.mobi.tasch.presenter.ProductsPresenter
import muh.mobi.tasch.ui.main.MainViewModel


class ProductsFragment: Fragment() {

    companion object {
        fun newInstance() = ProductsFragment()
    }

    private lateinit var viewModel: MainViewModel

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
                adapter = ProductsRecyclerViewAdapter(products, ::showDetails)
            }
        }
    }

    fun populateWishList(wishes: Array<Wish>) {

        val recyclerView = view?.findViewById<View>(R.id.whish_list)

        // Set the adapter
        if (recyclerView is RecyclerView) {
            with(recyclerView) {

                adapter = WishListRecyclerViewAdapter(wishes) { wish: Wish ->


                    //                    TFAManager.gigyaAssertionFor(registeredAddress, gigyaAssertions)?.let {
//                        listener?.invoke(registeredAddress, it)
//                    }
                }
            }
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
    }

    override fun onResume() {
        super.onResume()

        productsPresenter.loadProducts()
        productsPresenter.loadWithList()
    }

    val productDetailFragment by lazy  { ProductDetailFragment()}

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
