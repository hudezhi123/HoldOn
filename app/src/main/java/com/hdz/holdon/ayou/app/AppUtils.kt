package com.hdz.holdon.ayou.app

import android.content.Context
import android.util.DisplayMetrics

class AppUtils {
    companion object {
        fun getScreenSize(context: Context): Pair<Int, Int> {
            val metrics: DisplayMetrics = context.resources.displayMetrics
            return Pair(metrics.widthPixels, metrics.heightPixels)
        }

        fun getScreenHeight(context: Context): Int = getScreenSize(context).second

        fun getScreenWidth(context: Context): Int = getScreenSize(context).first


    }
}