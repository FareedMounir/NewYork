package com.example.newyork.ui.base

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import de.hdodenhof.circleimageview.CircleImageView

@BindingAdapter("res_image")
fun setImgToIv(iv: AppCompatImageView, url: String) {
    Glide.with(iv.context).load(url).into(iv)
}

@BindingAdapter("res_image")
fun setImgToIv(iv: CircleImageView, url: String) {
    Glide.with(iv.context).load(url).into(iv)
}