package muh.mobi.tasch.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import muh.mobi.tasch.R
import muh.mobi.tasch.adapter.ProductsRecyclerViewAdapter
import muh.mobi.tasch.model.Product

class ProductsFragment : Fragment() {

    companion object {
        fun newInstance() = ProductsFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
        ): View {
        return inflater.inflate(R.layout.fragment_produts_list, container, false)
    }

    fun populateList(products: Array<Product>) {

        val recyclerView = view?.findViewById<View>(R.id.list)

        // Set the adapter
        if (recyclerView is RecyclerView) {
            with(recyclerView) {

                adapter = ProductsRecyclerViewAdapter(products) { product: Product ->
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
        // TODO: Use the ViewModel
    }

}
