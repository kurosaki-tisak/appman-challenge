package com.devtee.appman.feature.image

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.devtee.appman.R
import com.devtee.appman.databinding.ActivityImageBinding
import com.devtee.appman.feature.AppManApplication
import com.devtee.appman.feature.image.di.DaggerImageComponent
import com.devtee.appman.feature.image.di.ImageModule

class ImageActivity : AppCompatActivity() {

    companion object {
        fun route(context: Context) {
            val intent = Intent(context, ImageActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityImageBinding = DataBindingUtil.setContentView(this, R.layout.activity_image)

        val component = DaggerImageComponent.builder()
                .applicationComponent(AppManApplication.applicationComponent)
                .imageModule(ImageModule(this))
                .build()

        val binder = ImageBinder(this, binding, component)
        binder.bindTo(this)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}