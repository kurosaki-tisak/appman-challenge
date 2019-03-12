package com.devtee.appman.helper

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.tbruyelle.rxpermissions2.RxPermissions

class RxPermissionsX : RxPermissions {
    constructor(activity: FragmentActivity) : super(activity)
    constructor(fragment: Fragment): super(fragment)
}