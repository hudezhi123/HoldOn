package com.hdz.holdon.ayou.http.base

import android.text.TextUtils
import com.alibaba.fastjson.JSONObject
import com.hdz.holdon.BuildConfig
import com.hdz.holdon.ayou.app.AppConfig
import com.hdz.holdon.ayou.app.AyouApplication
import com.hdz.holdon.ayou.dao.UserSp
import okhttp3.MediaType
import okhttp3.RequestBody
import java.lang.NullPointerException

class BaseRequest() {

    companion object {
        private val TAG: String = "BaseRequest"
        fun defaultBody(): RequestBody = Builder().build()
    }

    class Builder {

        var contentJson: JSONObject
        var requestJson: JSONObject

        constructor() {
            contentJson = JSONObject()
            requestJson = JSONObject()
            requestJson.put("app_version", BuildConfig.VERSION_NAME)
            requestJson.put("platform", "Android");
            requestJson.put("udid", AyouApplication.getUUID());
            requestJson.put("version", AppConfig.APP_VERSION);
            requestJson.put("content", contentJson);
        }


        fun put(key: String, value: Any?): Builder {
            contentJson.put(key, value ?: "")
            return this
        }

        fun put(key: String, vararg values: Pair<String, Any?>): Builder {
            if (values.size <= 0) {
                throw NullPointerException("there is no needed values for this request")
            } else {
                val jsonObj = JSONObject()
                values.forEach {
                    jsonObj.put(it.first, it.second)
                }
                contentJson.put(key,jsonObj)
            }
            return this
        }

        fun buildBodyStr():String{
            return requestJson.toJSONString()
        }

        private fun needAccessToken(): Builder {
            val access_token = UserSp.getUserAccessToken()
            needAccessToken(access_token)
            return this
        }

        fun needAccessToken(access_token: String): Builder {
            if (!TextUtils.isEmpty(access_token)) {
                requestJson.put("access_token", access_token)
            }
            return this
        }


        fun build(): RequestBody {
            val jsonStr = requestJson.toJSONString()
            return RequestBody.create(MediaType.parse("application/json"), jsonStr)
        }
    }
}