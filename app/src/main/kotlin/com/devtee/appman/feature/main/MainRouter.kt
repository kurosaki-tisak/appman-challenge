package com.devtee.appman.feature.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.devtee.appman.feature.alert.AlertActivity
import com.devtee.appman.feature.image.ImageActivity
import com.devtee.appman.feature.list.DataListActivity

interface MainRouter {
    fun openListActivity()
    fun openAlertActivity()
    fun openImageActivity()
    fun openCamera()
}

class MainRouterImpl(private val activity: AppCompatActivity) : MainRouter {

    override fun openListActivity() {
        DataListActivity.route(activity)
    }

    override fun openAlertActivity() {
        AlertActivity.route(activity)
    }

    override fun openImageActivity() {
        ImageActivity.route(activity)
    }

    override fun openCamera() {
        val intent = Intent("android.media.action.IMAGE_CAPTURE")
        activity.startActivity(intent)
    }
}