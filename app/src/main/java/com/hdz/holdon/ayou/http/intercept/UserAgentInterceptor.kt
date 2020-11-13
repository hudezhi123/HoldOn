package com.hdz.holdon.ayou.http.intercept

import com.hdz.holdon.ayou.app.AyouApplication
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class UserAgentInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request: Request = chain.request()
        val url: HttpUrl = request
            .url()
            .newBuilder()
            .build()
        val builder = request.newBuilder()
        builder.url(url)
        builder.addHeader("User-Agent", AyouApplication.UA)
        builder.method(request.method(), request.body())
        return chain.proceed(builder.build())
    }
}