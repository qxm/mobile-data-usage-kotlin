package com.qxm.mobiledata.viewmodel

import android.databinding.ObservableArrayList
import com.qxm.mobiledata.model.DataUsage
import com.qxm.mobiledata.model.MobileDataUsages
import com.qxm.mobiledata.net.ApiObserver
import com.qxm.mobiledata.net.repo.MobileDataRepository

class MobileDataVM : BaseVM() {
    val TAG = "MobileDataVM"
    val dataUsageList = ObservableArrayList<MobileDataUsages>()

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
                dataUsageList.addAll(it.result.records.groupBy{ it.quarter.substring(0,4) }.values.map{MobileDataUsages(it)})
                //android.util.Log.d(TAG,it.result.records.toString() )
            }, error = {
                resetLoadStatus()
            }))
    }
}