package com.libertystudio.bookshop

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide

fun Context.inflate(resource: Int, root: ViewGroup, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(this).inflate(resource, root, attachToRoot)
}

fun ImageView.showImage(url: String, placeholder: Int = R.drawable.placeholder_book) {
    Glide
            .with(this)
            .load(url)
            .placeholder(placeholder)
            .into(this)
}