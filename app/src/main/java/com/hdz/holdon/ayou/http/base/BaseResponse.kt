package com.hdz.holdon.ayou.http.base


class BaseResponse<T> {
    var code = 0
    var message: String? = null
    var sub_msg: String? = null
    var sub_code: String? = null
    var content: T? = null

}