package muh.mobi.tasch.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import muh.mobi.tasch.R

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
        ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    fun populateList(registeredAddress: Array<RegisteredAddress>, gigyaAssertions: Map<String, String> ) {

        val recyclerView = view?.findViewById<View>(R.id.list)

        // Set the adapter
        if (recyclerView is RecyclerView) {
            with(recyclerView) {

                adapter = RegisteredAddressRecyclerViewAdapter(registeredAddress) { registeredAddress: RegisteredAddress ->
                    TFAManager.gigyaAssertionFor(registeredAddress, gigyaAssertions)?.let {
                        listener?.invoke(registeredAddress, it)
                    }
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
