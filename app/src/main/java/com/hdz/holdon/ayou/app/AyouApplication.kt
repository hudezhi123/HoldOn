package com.hdz.holdon.ayou.app

import android.app.Application
import android.os.Build
import android.preference.PreferenceManager
import android.provider.Settings
import android.text.TextUtils
import com.hdz.holdon.BuildConfig
import com.hdz.holdon.ayou.util.EncryUtils
import java.util.*


class AyouApplication : Application() {

    companion object {
        lateinit var UA: String
        val instances by lazy {
            AyouApplication()
        }

        fun getUUID(): String {
            return ""
        }

        private fun generateUUID(): String {
            var id: String
            val sp =
                PreferenceManager.getDefaultSharedPreferences(instances)
            id = sp.getString("UUID", "")!!
            if (TextUtils.isEmpty(id)) {
                var android_id = Settings.Secure.getString(
                    instances.getContentResolver(),
                    Settings.Secure.ANDROID_ID
                )
                if (TextUtils.isEmpty(android_id)) android_id = "0"
                var device_sn = ""
                try {
                    device_sn =
                        "35" + Build.BOARD.length % 10 + Build.BRAND.length % 10 + Build.CPU_ABI.length % 10 + Build.DEVICE.length % 10 + Build.DISPLAY.length % 10 + Build.HOST.length % 10 + Build.ID.length % 10 + Build.MANUFACTURER.length % 10 + Build.MODEL.length % 10 + Build.PRODUCT.length % 10 + Build.TAGS.length % 10 + Build.TYPE.length % 10 + Build.USER.length % 10
                } catch (e: Exception) {
                    e.printStackTrace()
                }
                if (TextUtils.isEmpty(device_sn)) device_sn = "0"
                val uuid = UUID.randomUUID().toString()
                id = EncryUtils.getMd5Value(android_id).substring(8, 24) +
                        EncryUtils.getMd5Value(device_sn).substring(8, 24) +
                        EncryUtils.getMd5Value(uuid).substring(8, 24)
                sp.edit().putString("UUID", id).apply()
            }
            return id
        }
    }

    override fun onCreate() {
        super.onCreate()
        initUA()
    }


    private fun initUA() {
        val ua = "AyouVideo/%s (Platform %s; Android %s; Model %s; Screen %s);"
        val screen: String =
            AppUtils.getScreenHeight(this).toString() + "x" + AppUtils.getScreenWidth(
                this
            )
        UA = java.lang.String.format(
            ua,
            BuildConfig.VERSION_NAME,  //版本号
            "Android",  //平台
            Build.BRAND + " " + Build.VERSION.RELEASE,  //系统版本号
            Build.MODEL,  //机型
            screen //分辨率
        )
    }
}