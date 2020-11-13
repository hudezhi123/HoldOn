package com.hdz.holdon.ayou.dao

import android.content.Context
import android.content.SharedPreferences
import android.text.TextUtils
import com.alibaba.fastjson.JSON
import com.hdz.holdon.ayou.app.AyouApplication
import com.hdz.holdon.ayou.bean.UserInfo

class UserSp {

    companion object {
        private val TAG = "UserSp"

        private val SP_NAME_USER = "USER_SHARED"
        private val KEY_USER_INFO = "KEY_USER_INFO"
        private val KEY_USER_ACCESS_TOKEN = "KEY_USER_ACCESS_TOKEN"

        private fun getUserSp(): SharedPreferences {
            return AyouApplication.instances.getSharedPreferences(
                SP_NAME_USER,
                Context.MODE_PRIVATE
            )
        }

        fun clear() {
            getUserSp().edit().clear().apply()
        }

        fun isUserLogin(): Boolean {
            return getUserInfo() == null
        }

        fun getUserInfo(): UserInfo? {
            val str: String = getUserSp().getString(KEY_USER_INFO, "")!!
            if (TextUtils.isEmpty(str)) {
                return null
            }
            val userInfo: UserInfo? = JSON.parseObject(str, UserInfo::class.java)
            return userInfo
        }

        fun getUserAccessToken(): String {
            val access_token = getUserSp().getString(KEY_USER_ACCESS_TOKEN, "")!!
            return access_token
        }

        fun getUserId(): String {
            val userInfo: UserInfo? = getUserInfo()
            return userInfo?.user_id ?: ""
        }


        fun updatePhone(phone: String) {
            val userInfo: UserInfo? = getUserInfo()
            if (userInfo != null) {
                userInfo.phone_number = phone
                updateUserInfo(userInfo)
            }
        }


        fun putUserInfo(accessToken: String, userInfo: UserInfo) {
            val json: String = JSON.toJSONString(userInfo)
            getUserSp().edit()
                .putString(KEY_USER_INFO, json)
                .putString(KEY_USER_ACCESS_TOKEN, accessToken)
                .apply()
        }


        fun updateUserInfo(userInfo: UserInfo) {
            val json: String = JSON.toJSONString(userInfo)
            getUserSp().edit()
                .putString(KEY_USER_INFO, json)
                .apply()
        }

    }

}