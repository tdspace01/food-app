package com.example.ui.mapper

import androidx.annotation.DrawableRes
import com.example.ui.R

@DrawableRes
fun Int.toDrawableRes(): Int {
    return when (this) {
        101 -> R.drawable.pizza
        102 -> R.drawable.cup
        103 -> R.drawable.leaf
        else -> R.drawable.img_no_image_placeholder
    }
}