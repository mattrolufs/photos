package com.rolufs.photos.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.rolufs.photos.R
import com.rolufs.photos.model.Photo
import kotlinx.android.synthetic.main.photos_item.view.*

class CollectionsAdapter(val photos: List<Photo>) : RecyclerView.Adapter<CollectionsAdapter.PhotoHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.photos_item, parent, false)
        return PhotoHolder(view)
    }

    override fun getItemCount(): Int {
        return photos.size
    }

    override fun onBindViewHolder(holder: PhotoHolder, position: Int) {
        val photo = photos.get(position)
        holder.setData(photo)
    }

    inner class PhotoHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun setData(photo: Photo) {

            Glide
                .with(itemView.context)
                .load(photo.thumbnailUrl)
                .fitCenter()
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                .into(itemView.image_photo_item);

            itemView.text_album.text = "Album Id: ${photo.albumId.toString()}"
            itemView.text_photo_id.text = "Photo Id: ${photo.id.toString()}"
            itemView.text_title.text = photo.title.toString()

            itemView.setOnClickListener {

                val action = CollectionsFragmentDirections.actionCollectionsFragment2ToDetailsFragment(photo.id)
                itemView.findNavController().navigate(action)
            }
        }

    }
}