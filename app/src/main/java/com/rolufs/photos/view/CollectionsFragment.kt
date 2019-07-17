package com.rolufs.photos.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rolufs.photos.R
import com.rolufs.photos.model.response.Photo
import com.rolufs.photos.viewmodel.CollectionsViewModel
import kotlinx.android.synthetic.main.collections_fragment.*


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

        val layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        recycler_view_photos.layoutManager = layoutManager


        viewModel.fetchPhotos().observe(this, Observer<List<Photo>> {
                val photosAdapter = CollectionsAdapter(it)
            recycler_view_photos.adapter = photosAdapter
        })
    }

}
