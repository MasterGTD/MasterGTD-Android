package info.zhufree.mastergtd.utils

import android.content.Context
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import android.widget.Toast.LENGTH_SHORT
import info.zhufree.mastergtd.MasterApplication

/**
 * Created by zhufree on 2018/2/26.
 * toast 工具类
 */

object Toaster {

    var toast: Toast? = null

    fun show(message: String, len: Int = LENGTH_SHORT, context: Context? = MasterApplication.app) {
        toast = Toast.makeText(context, message, len)
        toast?.show()
    }

    fun showLong(message: String, len: Int = LENGTH_LONG, context: Context? = MasterApplication.app) {
        if (toast != null) {
            toast = Toast.makeText(context, message, len)
        } else {
            toast?.duration = LENGTH_LONG
        }
        toast?.show()
    }

    fun showLongX(message: String, context: Context? = MasterApplication.app) {
        showLong(message, context = context)
        showLong(message, context = context)
    }

    /**
     * 取消显示
     */
    fun end() {
        toast?.cancel()
    }
}
