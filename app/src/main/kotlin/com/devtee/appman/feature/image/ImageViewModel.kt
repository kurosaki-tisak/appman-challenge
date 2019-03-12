package com.devtee.appman.feature.image

import android.content.Context
import android.graphics.Bitmap
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.devtee.appman.helper.toBitmap
import org.json.JSONObject

class ImageViewModel(context: Context) : ViewModel() {

    val data = MutableLiveData<List<Bitmap>>()

    init {

        val encodeString = context.resources.openRawResource(com.devtee.appman.R.raw.base64).bufferedReader().use { it.readText() }
        val obj = JSONObject(encodeString)

        Log.v("DEV", "${obj}")
    }

}

fun List<String>.convertBitmap() : List<Bitmap> {
    return this.asSequence().map { item -> item.toBitmap() }.toList()
}