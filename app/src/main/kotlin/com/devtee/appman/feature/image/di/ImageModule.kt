package com.devtee.appman.feature.image.di

import android.content.Context
import com.devtee.appman.feature.image.ImageViewModel
import dagger.Module
import dagger.Provides

@Module
class ImageModule(val context: Context) {

    @Provides
    @ImageScope
    fun provideImageViewModel(): ImageViewModel = ImageViewModel(context)
}