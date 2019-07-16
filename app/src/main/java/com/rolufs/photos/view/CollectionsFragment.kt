package com.rolufs.photos.view

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.rolufs.photos.viewmodel.CollectionsViewModel
import com.rolufs.photos.R
import com.rolufs.photos.model.response.Photo
import com.rolufs.photos.model.response.PhotoAPI
import kotlinx.android.synthetic.main.collections_fragment.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


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
        return inflater.inflate(R.layout.collections_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CollectionsViewModel::class.java)

        val photoAPI = PhotoAPI()

        viewModel.fetchPhotos().observe(this, Observer<List<Photo>> {
                textView.text = it.size.toString()
            })
    }

}
