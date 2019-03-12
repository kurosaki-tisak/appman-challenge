package com.devtee.appman.feature.main

import android.Manifest
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.devtee.appman.common.Binder
import com.devtee.appman.common.viewModel
import com.devtee.appman.databinding.ActivityMainBinding
import com.devtee.appman.feature.main.di.MainComponent
import com.devtee.appman.helper.RxPermissionsX

class MainBinder(
    private val activity: AppCompatActivity,
    binding: ActivityMainBinding,
    component: MainComponent
) : Binder {

    private val viewModel = activity.viewModel { component.getMainViewModel() }
    private val view = MainViewImpl(binding, viewModel)
    private val router = MainRouterImpl(activity)

    init {
        binding.viewModel = viewModel
    }

    override fun bindTo(owner: LifecycleOwner) {
        viewModel.data.observe(owner, Observer { view.setItems(it) })

        viewModel.openListMenuEvent.observe(owner, Observer { router.openListActivity() })
        viewModel.openAlertMenuEvent.observe(owner, Observer { router.openAlertActivity() })
        viewModel.openImageMenuEvent.observe(owner, Observer { router.openImageActivity() })
        viewModel.openCameraMenuEvent.observe(owner, Observer { router.openCamera() })

        viewModel.checkCameraPermissionEvent.observe(owner, Observer {

            RxPermissionsX(activity)
                .request(Manifest.permission.CAMERA)
                .subscribe { granted -> viewModel.cameraGranted(granted) }
        })
    }
}