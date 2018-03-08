package info.zhufree.mastergtd.utils

import info.zhufree.mastergtd.MasterApplication

/**
 * Created by zhufree on 2018/2/26.
 *
 */
object Converter {
    var scale = MasterApplication.app?.resources?.displayMetrics?.density ?: 3f
    val fontScale = MasterApplication.app?.resources?.displayMetrics?.scaledDensity ?: 2.5f

    fun dp2px(dip: Int) : Int {
        return (dip.times(scale) + 0.5f).toInt()
    }

    fun px2dp(px: Float): Int {
        return (px.div(scale) + 0.5f).toInt()
    }

    fun sp2px(sp: Int) : Int {

        return (sp.times(fontScale) + 0.5f).toInt()
    }

    fun px2sp(px: Float): Int {
        return (px.div(fontScale) + 0.5f).toInt()
    }
}