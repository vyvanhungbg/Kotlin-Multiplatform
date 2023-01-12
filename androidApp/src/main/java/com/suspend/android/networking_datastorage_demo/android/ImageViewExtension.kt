package com.suspend.android.networking_datastorage_demo.android

import android.widget.ImageView
import androidx.core.net.toUri
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

fun ImageView.loadImage(path: String?) {
    Glide.with(this)
        .load(path)
        .transition(DrawableTransitionOptions.withCrossFade())
        .into(this)
}
