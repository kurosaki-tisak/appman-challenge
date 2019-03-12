package com.devtee.appman.di

import com.google.gson.Gson
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ContextModule::class])
interface ApplicationComponent {
    fun getGson(): Gson
}