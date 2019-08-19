package com.qxm.mobiledata.net.remote

import com.qxm.mobiledata.model.DataUsageResult
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface DataUsageApi {
    //datastore_search?resource_id=a807b7ab-6cad-4aa6-87d0-e283a7353a0f
    @GET("datastore_search")
    fun getMobileDataUsage(@Query("resource_id") resource_id: String): Observable<DataUsageResult>
}