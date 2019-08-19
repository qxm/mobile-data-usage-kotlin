package com.qxm.mobiledata.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.content.Intent

open class BaseVM : ViewModel() {

    val isFirstLoading = MutableLiveData<Boolean>()

    val isLoadingMore = MutableLiveData<Boolean>()

    val isRefreshing = MutableLiveData<Boolean>()

    val isEmpty = MutableLiveData<Boolean>()



    open fun onRefresh() {
        isRefreshing.value = true
    }

    open fun onLoadMore() {
        isLoadingMore.value = true
    }

    open fun onFirstLoad() {
        isFirstLoading.value = true
    }

    open fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
    }

    /**
     * 重置加载状态
     */
    fun resetLoadStatus() {
        if (isFirstLoading.value == true) {
            isFirstLoading.value = false
        }
        if (isLoadingMore.value == true) {
            isLoadingMore.value = false
        }
        if (isRefreshing.value == true) {
            isRefreshing.value = false
        }
    }
}
