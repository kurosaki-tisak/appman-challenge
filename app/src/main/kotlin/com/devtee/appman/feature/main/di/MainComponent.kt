package com.devtee.appman.feature.main.di

import com.devtee.appman.di.ApplicationComponent
import com.devtee.appman.feature.main.MainViewModel
import dagger.Component

@MainScope
@Component(dependencies = [ApplicationComponent::class], modules = [MainModule::class])
interface MainComponent {
    fun getMainViewModel(): MainViewModel
}