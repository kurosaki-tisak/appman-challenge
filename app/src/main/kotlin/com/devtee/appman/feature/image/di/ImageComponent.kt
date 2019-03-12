package com.devtee.appman.feature.image.di

import com.devtee.appman.di.ApplicationComponent
import com.devtee.appman.feature.image.ImageViewModel
import dagger.Component

@ImageScope
@Component(dependencies = [ApplicationComponent::class], modules = [ImageModule::class])
interface ImageComponent {
    fun getImageViewModel(): ImageViewModel
}