package com.hdz.holdon.test

class NetUtils private constructor() {

    var age = 10

    companion object {
        var name = "张三"  //静态
        val instance by lazy { NetUtils() }
    }

}