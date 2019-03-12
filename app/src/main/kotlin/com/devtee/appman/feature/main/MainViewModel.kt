package com.devtee.appman.feature.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.devtee.appman.common.SingleLiveEvent

class MainViewModel : ViewModel() {

    val onItemClickEvent: (MainItem) -> Unit = { onItemClicked(it) }
    val openListMenuEvent = SingleLiveEvent<Unit>()
    val openAlertMenuEvent = SingleLiveEvent<Unit>()
    val openImageMenuEvent = SingleLiveEvent<Unit>()
    val openCameraMenuEvent = SingleLiveEvent<Unit>()

    val checkCameraPermissionEvent = SingleLiveEvent<Unit>()

    val data = MutableLiveData<List<MainItem>>()

    init {
        data.value = setItems()
    }

    private fun setItems(): List<MainItem> {
        val menuList: List<MainItem> by lazy {
            listOf(
                MainItem(1, "json"),
                MainItem(2, "alert"),
                MainItem(3, "image"),
                MainItem(4, "camera")
            )
        }
        return menuList.map { item ->
            item.display = "${item.id}: ${item.name}"
            return@map item
        }
    }

    private fun onItemClicked(item: MainItem) {
        when (item.id) {
            1 -> openListMenuEvent.call()
            2 -> openAlertMenuEvent.call()
            3 -> openImageMenuEvent.call()
            4 -> checkCameraPermissionEvent.call()
            else -> throw Exception("There is no ${item.name} match!!")
        }
    }

    fun cameraGranted(isGranted: Boolean) {
        if (isGranted)
            openCameraMenuEvent.call()
        else
            checkCameraPermissionEvent.call()
    }
}