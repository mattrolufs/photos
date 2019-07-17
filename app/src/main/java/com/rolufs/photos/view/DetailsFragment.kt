package com.rolufs.photos.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.rolufs.photos.R
import com.rolufs.photos.viewmodel.DetailsViewModel
import kotlinx.android.synthetic.main.details_fragment.*
import kotlinx.android.synthetic.main.details_fragment.view.*


class DetailsFragment : Fragment() {

    val args: DetailsFragmentArgs by navArgs()

    companion object {
        fun newInstance() = DetailsFragment()
    }

    private lateinit var viewModel: DetailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.details_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(DetailsViewModel::class.java)

        viewModel.fetchPhoto(args.photoId).observe(this, Observer {
            Glide
                .with(context!!)
                .load(it.url)
                .fitCenter()
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                .into(image_detail_photo.image_detail_photo);

            text_detail_album_id.text = "Album Id: ${it.albumId.toString()}"
            text_detail_photo_id.text = "Photo Id: ${it.id.toString()}"
            text_detail_photo_title.text = it.title.toString()
        })

    }

}
