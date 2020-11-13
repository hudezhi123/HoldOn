package com.hdz.holdon.ayou.app

//
interface AppConfig {

    companion object {
        const val DEBUG: Boolean = true
        const val APP_VERSION: String = "1.00"
    }


    /**
     * 友盟
     */
    interface Umeng {
        companion object {
            //APP_KEY
            const val APP_KEY = "5c2d6334f1f556e20d000604"
        }
    }

    /**
     * 微信
     */
    interface WeChat {
        companion object {
            //APP_KEY
            const val APP_KEY = "wx0739e3b472167af0"
            //appSecret
            const val APP_SECRET = "bdf42138e06a9eb9e7fb4b25a47a04cb"
            //重定向地址
            const val REDIRECT_URL = "http://www.docin.com/app/weixin/login"
        }
    }

    /**
     * 新浪
     */
    interface Sina {
        companion object {
            //APP_KEY
            const val APP_KEY = "3944975425"
            //appSecret
            const val APP_SECRET = "43192e22607df23e942e3bf31373282c"
            //重定向地址
            const val REDIRECT_URL = "http://ayou.docin.com/user/oauth-callback" //正式
            //        String REDIRECT_URL = "https://ayou.docin.com/api/test_third_callback";  //测试
        }
    }

    /**
     * QQ
     */
    interface QQ {
        companion object {
            //APP_KEY
            const val APP_KEY = "101539649"
            //appSecret
            const val APP_SECRET = "66470b5dcfee6f262eee1820de901225"
        }
    }

    /**
     * DOCIN
     */
    interface Docin {
        companion object {
            //APP_KEY
            const val APP_KEY = "docin5ec159e16a7e8b62"
            //appSecret
            const val APP_SECRET = "2abeb0accd4a51927bb5e8e7a8ca90be"
            //RedirectUri
            const val REDIRECT_URL = "http://ayou.docin.com/api/test_third_callback"
        }
    }

    //发送验证码的场景 qq, wechat, weibo, docin
    interface LoginType {
        companion object {
            const val QQ = "qq" //register注册
            const val WECHAT = "wechat" //pwd_reset密码重置
            const val WEIBO = "weibo" //bind_phone绑定手机号
            const val DOCIN = "docin" //bind_phone绑定手机号
        }
    }

    //登录注册密码6-20位
    interface PasswordLength {
        companion object {
            const val MAX = 20
            const val MIN = 6
        }
    }

    //发送验证码的场景
    interface SendSmsScene {
        companion object {
            const val REGISTER = "register" //register注册
            const val PWD_RESET = "pwd_reset" //pwd_reset密码重置
            const val BIND_PHONE = "bind_phone" //bind_phone绑定手机号
            const val QUICK_LOGIN = "quick_login" //quick_login快速登录
            const val CHANGE_PWD = "change_pwd" //change_pwd 修改密码
        }
    }
}