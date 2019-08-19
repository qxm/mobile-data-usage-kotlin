package com.qxm.mobiledata.viewmodel

import android.databinding.ObservableArrayList
import com.qxm.mobiledata.model.DataUsage
import com.qxm.mobiledata.net.ApiObserver
import com.qxm.mobiledata.net.repo.MobileDataRepository

class MobileDataVM : BaseVM() {
    val TAG = "MobileDataVM"
    val dataUsageList = ObservableArrayList<DataUsage>()

    override fun onFirstLoad() {
        super.onFirstLoad()
        load()
    }

    override fun onRefresh() {
        super.onRefresh()
        load()
    }

    private fun load() {
        MobileDataRepository.getMobileDataUsage()
            .subscribe(ApiObserver(success = {
                resetLoadStatus()
                dataUsageList.clear()
                dataUsageList.addAll(it.result.records)
                //android.util.Log.d(TAG,it.result.records.toString() )
            }, error = {
                resetLoadStatus()
            }))
    }
}