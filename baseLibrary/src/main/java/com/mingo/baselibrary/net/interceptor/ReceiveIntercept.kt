package com.mingo.baselibrary.net.interceptor

import android.content.Context
import okhttp3.Interceptor
import okhttp3.Response

class ReceiveIntercept(context: Context) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        return chain.proceed(chain.request())
    }
}