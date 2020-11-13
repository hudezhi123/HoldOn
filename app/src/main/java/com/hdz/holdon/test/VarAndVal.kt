package com.hdz.holdon.test

class VarAndVal {
    fun test() {
        var address: String = """
            廣東省
            深圳市
            寶安區
            """.trimIndent()
        println(address)

        val arr = IntArray(5) {
            34
        }
        val brr = IntArray(4) {
            12
        }
        tag1@arr.forEach {
            tag2@brr.forEachIndexed { index, b ->
                println(it + b)
            }
        }
    }

    fun max(a: Int, b: Int): Int = if (a > b) a else b
}