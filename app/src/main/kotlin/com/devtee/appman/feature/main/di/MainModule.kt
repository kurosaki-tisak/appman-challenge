package com.devtee.appman.feature.main.di

import com.devtee.appman.feature.main.MainViewModel
import dagger.Module
import dagger.Provides

@Module
class MainModule {

    @Provides
    @MainScope
    fun provideMainViewModel(): MainViewModel = MainViewModel()
}