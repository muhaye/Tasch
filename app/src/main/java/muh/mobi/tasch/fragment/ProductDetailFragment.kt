package muh.mobi.tasch.fragment

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import muh.mobi.tasch.R
import muh.mobi.tasch.databinding.FragmentProductDetailBinding
import muh.mobi.tasch.model.Product
import muh.mobi.tasch.presenter.ProductDetailsPresenter

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [ProductDetailFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [ProductDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProductDetailFragment: Fragment() {

    private val pDetailsPresenter by lazy {  ProductDetailsPresenter() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        val binding: FragmentProductDetailBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_product_detail, container, false)
        val view = binding.root

        binding.presenter = pDetailsPresenter

        return view
    }

    fun onProduct(product: Product){
        pDetailsPresenter.onProduct(product)
    }

}
