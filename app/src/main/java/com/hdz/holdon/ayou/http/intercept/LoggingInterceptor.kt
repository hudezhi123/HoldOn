package com.hdz.holdon.ayou.http.intercept

import okhttp3.Interceptor
import okhttp3.Response
import java.util.*

class LoggingInterceptor:Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val response = chain.proceed(request)
        return response
    }

}