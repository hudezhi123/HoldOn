package com.hdz.holdon.ayou.http.ssl

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import java.net.Socket
import java.security.SecureRandom
import java.security.cert.X509Certificate
import javax.net.ssl.*

class SSLSocketClient {
    companion object {
        fun getSSLSocketFactory(): SSLSocketFactory {
            val sslContext: SSLContext = SSLContext.getInstance("SSL")
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                sslContext.init(null, getTrustManagerN(), SecureRandom())
            } else {
                sslContext.init(null, getTrustManager(), SecureRandom())
            }
            return sslContext.socketFactory
        }

        @RequiresApi(Build.VERSION_CODES.N)
        open class TrustAllCerts() : X509ExtendedTrustManager() {
            override fun checkClientTrusted(
                chain: Array<out X509Certificate>?,
                authType: String?,
                socket: Socket?
            ) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun checkClientTrusted(
                chain: Array<out X509Certificate>?,
                authType: String?,
                engine: SSLEngine?
            ) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun checkClientTrusted(chain: Array<out X509Certificate>?, authType: String?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun checkServerTrusted(
                chain: Array<out X509Certificate>?,
                authType: String?,
                socket: Socket?
            ) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun checkServerTrusted(
                chain: Array<out X509Certificate>?,
                authType: String?,
                engine: SSLEngine?
            ) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun checkServerTrusted(chain: Array<out X509Certificate>?, authType: String?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun getAcceptedIssuers(): Array<X509Certificate> {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        }

        @RequiresApi(Build.VERSION_CODES.N)
        private fun getTrustManagerN(): Array<TrustManager> {
            return arrayOf(TrustAllCerts())
        }

        private fun getTrustManager(): Array<TrustManager> {
            return arrayOf(object : X509TrustManager {
                @SuppressLint("TrustAllX509TrustManager")
                override fun checkClientTrusted(
                    chain: Array<out X509Certificate>?,
                    authType: String?
                ) {

                }

                override fun checkServerTrusted(
                    chain: Array<out X509Certificate>?,
                    authType: String?
                ) {

                }

                override fun getAcceptedIssuers(): Array<X509Certificate> {
                    return arrayOf()
                }
            })
        }

        fun getHostNameVerifier(): HostnameVerifier {
            return object : HostnameVerifier {
                override fun verify(hostname: String?, session: SSLSession?): Boolean {
                    return true
                }
            }
        }
    }
}