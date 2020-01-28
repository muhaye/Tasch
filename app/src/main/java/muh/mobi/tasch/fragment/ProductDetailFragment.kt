package muh.mobi.tasch.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_product_detail.*
import muh.mobi.tasch.R
import muh.mobi.tasch.databinding.FragmentProductDetailBinding
import muh.mobi.tasch.model.Product
import muh.mobi.tasch.model.Store
import muh.mobi.tasch.presenter.ProductDetailsPresenter

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

    override fun onResume() {
        super.onResume()

        addToWish?.setOnClickListener {

            pDetailsPresenter.product?.let {

                if ( Store.wishlist.contains(it))
                    Store.wishlist.remove(it)
                else
                    Store.wishlist.add(it)

                pDetailsPresenter.isInWishList?.set(Store.wishlist.contains(it))

                fragmentManager?.popBackStack()
            }
        }

        pDetailsPresenter.product?.let {
            activity?.setTitle(it.title)
        }
    }

}
