package com.qxm.mobiledata

import android.app.Application
import android.content.Context

class MobileDataApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        context = this
    }

    companion object {
        @JvmField
        var context: Context? = null

        @JvmStatic
        fun getContext(): Context? = context
    }
}