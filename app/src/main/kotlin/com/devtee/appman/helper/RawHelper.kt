package com.devtee.appman.helper

import android.content.Context
import androidx.annotation.RawRes
import com.google.gson.Gson

inline fun <reified T> Context.jsonFromRawToClass(@RawRes resourceId: Int): T =
    Gson().fromJson(resources.openRawResource(resourceId).bufferedReader().use { it.readText() }, T::class.java)