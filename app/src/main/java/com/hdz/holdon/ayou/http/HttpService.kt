package com.hdz.holdon.ayou.http

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class HttpService private constructor() {
    var mRetrofit: Retrofit

    init {
        mRetrofit = Retrofit.Builder()
            .client(OkClient.getOkClient())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(Api.BASE_URL)
            .build()
    }

    companion object {
        class SingleHolder {
            companion object {
                val instance by lazy {
                    HttpService()
                }
            }
        }


        fun get(): Retrofit = SingleHolder.instance.mRetrofit
    }


}