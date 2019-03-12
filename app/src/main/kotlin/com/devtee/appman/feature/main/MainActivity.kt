package com.devtee.appman.feature.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.devtee.appman.R
import com.devtee.appman.databinding.ActivityMainBinding
import com.devtee.appman.feature.AppManApplication
import com.devtee.appman.feature.main.di.DaggerMainComponent
import com.devtee.appman.feature.main.di.MainModule

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val component = DaggerMainComponent.builder()
            .applicationComponent(AppManApplication.applicationComponent)
            .mainModule(MainModule())
            .build()

        val binder = MainBinder(this, binding, component)
        binder.bindTo(this)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}