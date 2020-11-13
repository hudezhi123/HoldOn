package com.hdz.holdon.ayou.http

import android.os.Build
import com.hdz.holdon.ayou.http.intercept.LoggingInterceptor
import com.hdz.holdon.ayou.http.intercept.UpLoadInterceptor
import com.hdz.holdon.ayou.http.intercept.UserAgentInterceptor
import com.hdz.holdon.ayou.http.ssl.SSLSocketClient
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

class OkClient {

    companion object {
        val TAG = "OkClient"
        const val DEFAULT_CONNECT_TIMEOUT: Long = 5
        const val DEFAULT_WRITE_TIMEOUT: Long = 10
        const val DEFAULT_READ_TIMEOUT: Long = 10

        fun getOkClient(): OkHttpClient {
            val builder = OkHttpClient.Builder()
            builder.connectTimeout(DEFAULT_CONNECT_TIMEOUT, TimeUnit.SECONDS)
            builder.writeTimeout(DEFAULT_WRITE_TIMEOUT, TimeUnit.SECONDS)
            builder.readTimeout(DEFAULT_READ_TIMEOUT, TimeUnit.SECONDS)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                builder.sslSocketFactory(
                    SSLSocketClient.getSSLSocketFactory(),
                    SSLSocketClient.Companion.TrustAllCerts()
                )
            } else {
                builder.sslSocketFactory(SSLSocketClient.getSSLSocketFactory())
            }
            builder.hostnameVerifier(SSLSocketClient.getHostNameVerifier())
            builder.addInterceptor(UserAgentInterceptor())
            builder.addInterceptor(LoggingInterceptor())
            builder.addInterceptor(UpLoadInterceptor())
            return builder.build()
        }
    }

}