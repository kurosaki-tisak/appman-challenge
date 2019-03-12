package com.devtee.appman.feature.list.di

import android.content.Context
import com.devtee.appman.feature.list.DataListViewModel
import dagger.Module
import dagger.Provides

@Module
class DataListModule(val context: Context) {

    @Provides
    @DataListScope
    fun provideDataListViewModel(): DataListViewModel = DataListViewModel(context)
}