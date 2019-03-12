package com.devtee.appman.di

import android.app.Application
import android.content.Context
import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ContextModule(private val application: Application) {

    @Provides
    fun provideContext(): Context = application.applicationContext

    @Provides
    fun providesApplication(): Application = application

    @Singleton
    @Provides
    fun provideGson() = GsonBuilder()
        .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
        .create()
}