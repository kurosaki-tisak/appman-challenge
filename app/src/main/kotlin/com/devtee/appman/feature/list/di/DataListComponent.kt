package com.devtee.appman.feature.list.di

import com.devtee.appman.di.ApplicationComponent
import com.devtee.appman.feature.list.DataListViewModel
import dagger.Component

@DataListScope
@Component(dependencies = [ApplicationComponent::class], modules = [DataListModule::class])
interface DataListComponent {
    fun getDataListViewModel(): DataListViewModel
}