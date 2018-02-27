package info.zhufree.mastergtd.utils

import android.util.Log

/**
 * Created by zhufree on 2018/2/26.
 * Log工具类
 */

object Logger {

    var DEBUG = true
    var DEFAULT_TAG = "master_logger"

    fun setDebug(flag: Boolean) {
        DEBUG = flag
    }

    fun i(message: String, tag: String = DEFAULT_TAG) {
        if (DEBUG) Log.i(tag, message)
    }

    fun e(message: String, tag: String = DEFAULT_TAG) {
        if (DEBUG) Log.e(tag, message)
    }

    fun w(message: String, tag: String = DEFAULT_TAG) {
        if (DEBUG) Log.w(tag, message)
    }

    fun d(message: String, tag: String = DEFAULT_TAG) {
        if (DEBUG) Log.d(tag, message)
    }

    fun v(message: String, tag: String = DEFAULT_TAG) {
        if (DEBUG) Log.v(tag, message)
    }

    fun wtf(message: String, tag: String = DEFAULT_TAG) {
        if (DEBUG) Log.wtf(tag, message)
    }
}
