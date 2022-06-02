package com.example.miaow.picture.selector.bean

import android.net.Uri
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class MediaBean(
    val name: String,
    var uri: Uri,
    var width: Int = 0,
    var height: Int = 0,
    var mimeType: String = "*/*",
) : Parcelable {

    /**
     * 长图
     */
    fun longImage(): Boolean {
        val h = width * 3
        return height > h
    }

    /**
     * gif图
     */
    fun gifImage(): Boolean {
        return when (mimeType) {
            "image/gif", "image/GIF" -> true
            else -> false
        }
    }

}