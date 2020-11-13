package com.hdz.holdon.ayou.http

import com.hdz.holdon.ayou.bean.LoginResp
import com.hdz.holdon.ayou.bean.ProfileInfo
import com.hdz.holdon.ayou.http.base.BaseResponse
import io.reactivex.Observable
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.POST

interface Api {


    companion object {
        const val BASE_URL = "https://ayou.docin.com/app/api/tick/"
        const val WEB_BASE_URL = "https://ayou.docin.com/app/page/index.html#/"
        const val WEB_SHARE_URL = "https://ayou.docin.com/app/sharestory/index.html#/?"
    }

    //登录
    @POST("auth/login")
    fun login(@Body requestBody: RequestBody): Observable<BaseResponse<LoginResp>>

    //快捷登录
    @POST("auth/quick_login")
    fun quickLogin(@Body requestBody: RequestBody): Observable<BaseResponse<LoginResp>>

    //获取登录用户资料
    @POST("profile/profile_info")
    fun getProfileInfo(@Body requestBody: RequestBody): Observable<BaseResponse<ProfileInfo>>


}