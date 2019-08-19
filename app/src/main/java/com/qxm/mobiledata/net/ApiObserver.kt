package com.qxm.mobiledata.net

import android.widget.Toast
import com.qxm.mobiledata.MobileDataApplication
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

class ApiObserver<T>(val start: (d: Disposable) -> Unit = {},
                     val error: (e: Throwable) -> Unit = {},
                     val finish: () -> Unit = {},
                     val success: (T) -> Unit = {}
) : Observer<T> {
    override fun onSubscribe(d: Disposable) {
        start(d)
    }

    override fun onError(e: Throwable) {
        Toast.makeText(MobileDataApplication.getContext(), handleError(e), Toast.LENGTH_SHORT).show()
        error(e)
    }

    override fun onComplete() {
        finish()
    }


    override fun onNext(t: T) {
        success(t)
    }
}