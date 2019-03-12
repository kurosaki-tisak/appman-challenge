package com.devtee.appman.feature.list

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.devtee.appman.R
import com.devtee.appman.databinding.ActivityDataListBinding
import com.devtee.appman.feature.AppManApplication
import com.devtee.appman.feature.list.di.DaggerDataListComponent
import com.devtee.appman.feature.list.di.DataListModule

class DataListActivity : AppCompatActivity() {

    companion object {
        fun route(context: Context) {
            val intent = Intent(context, DataListActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityDataListBinding = DataBindingUtil.setContentView(this, R.layout.activity_data_list)

        val component = DaggerDataListComponent.builder()
                .applicationComponent(AppManApplication.applicationComponent)
                .dataListModule(DataListModule(this))
                .build()

        val binder = DataListBinder(this, binding, component)
        binder.bindTo(this)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}