package info.zhufree.mastergtd.utils

import info.zhufree.mastergtd.MasterApplication

/**
 * Created by zhufree on 2018/2/26.
 *
 */
object Converter {
    fun dp2px(dip: Int) : Int {
        var scale = MasterApplication.app?.resources?.displayMetrics?.density
        scale = if (scale == null) 3f else scale
        return (dip.times(scale) + 0.5f).toInt()
    }
}