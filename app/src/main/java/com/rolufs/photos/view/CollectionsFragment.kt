package com.rolufs.photos.view

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import com.rolufs.photos.viewmodel.CollectionsViewModel
import com.rolufs.photos.R


class CollectionsFragment : Fragment() {

    companion object {
        fun newInstance() = CollectionsFragment()
    }

    private lateinit var viewModel: CollectionsViewModel

    private lateinit var viewOfLayout: View
    private var button : Button? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //return inflater.inflate(R.layout.collections_fragment, container, false)

        viewOfLayout = inflater.inflate(R.layout.collections_fragment, container, false)

        button = viewOfLayout.findViewById(R.id.button)

        button!!.setOnClickListener{ view ->
            view.findNavController().navigate(R.id.action_collectionsFragment2_to_detailsFragment)

        }

        return viewOfLayout
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CollectionsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
