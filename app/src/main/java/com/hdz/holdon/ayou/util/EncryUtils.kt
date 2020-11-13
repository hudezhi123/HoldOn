package com.hdz.holdon.ayou.util

import java.security.MessageDigest

class EncryUtils {
    companion object {
        fun getMd5Value(secret: String): String {
            val md5 = MessageDigest.getInstance("MD5")
            md5.update(secret.toByteArray())
            val sb = StringBuilder()
            val b = md5.digest()
            var i:Byte=0
            b.forEach {
                i =it
                if(i<0) {
                    i= (i+256).toByte()
                }else if(i<16){
                    sb.append("0")
                }
                sb.append(Integer.toHexString(i.toInt()))
            }
            return sb.toString()
        }
    }
}