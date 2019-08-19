package com.qxm.mobiledata.utils.funcextend

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer
import android.support.annotation.NonNull

fun <T> MutableLiveData<T>.observe(@NonNull owner: LifecycleOwner, @NonNull method: (T?) -> Unit) {
    observe(owner, Observer {
        method(it)
    })
}