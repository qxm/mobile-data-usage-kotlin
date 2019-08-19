package com.qxm.mobiledata.net.repo

import com.qxm.mobiledata.model.DataUsageResult
import com.qxm.mobiledata.net.ApiProvider
import com.qxm.mobiledata.net.Io2UiTransform
import com.qxm.mobiledata.net.remote.DataUsageApi
import io.reactivex.Observable

object MobileDataRepository {
    val RESOURCE_ID = "a807b7ab-6cad-4aa6-87d0-e283a7353a0f"
    private val remoteSource by lazy {
        ApiProvider.create(DataUsageApi::class.java)
    }

    fun getMobileDataUsage(): Observable<DataUsageResult> = remoteSource.getMobileDataUsage(RESOURCE_ID).compose(Io2UiTransform())
}