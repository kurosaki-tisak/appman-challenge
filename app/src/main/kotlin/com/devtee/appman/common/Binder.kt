package com.devtee.appman.common

import androidx.lifecycle.LifecycleOwner

interface Binder {
    fun bindTo(owner: LifecycleOwner)
}