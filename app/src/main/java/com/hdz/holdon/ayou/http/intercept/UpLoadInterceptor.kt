package com.hdz.holdon.ayou.http.intercept

import okhttp3.Interceptor
import okhttp3.Response
import org.greenrobot.eventbus.EventBus

class UpLoadInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val response = chain.proceed(request)
//        val code = response.code()
//        if (code == 501 || code == 502 || code == 503 || code == 504) {
//            val httpUrl = request.url().toString()
//            if (httpUrl.contains("/upload/") && !httpUrl.contains("story_list")) { // TODO: 2020-06-03   提交和上传过程失败了
//                EventBus.getDefault().post(ServersErrorEvent(false))
//            }
//        } else {
//            val httpUrl = request.url().toString()
//            if (httpUrl.contains("/upload/") && !httpUrl.contains("story_list")) { // TODO: 2020-06-03   提交和上传过程失败了
//                EventBus.getDefault().post(ServersErrorEvent(true))
//            }
//        }
        return response
    }
}