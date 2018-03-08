package info.zhufree.mastergtd.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.support.design.widget.FloatingActionButton
import android.util.AttributeSet
import android.view.View
import info.zhufree.mastergtd.R
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.RelativeLayout
import android.widget.TextView
import info.zhufree.mastergtd.utils.Converter


/**
 * Created by zhufree on 2018/2/26.
 *
 */

class SubButtonLayout : RelativeLayout {

    var captionTextList: MutableList<TextView> = emptyList<TextView>().toMutableList()
    var subButtonList: MutableList<FloatingActionButton> = emptyList<FloatingActionButton>().toMutableList()
    private var defaultTextSizePx = Converter.sp2px(12).toFloat()
    private var captionTextSize: Float? = null
    private var captionTextColor: Int? = null

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        // 从attrs定义文件中获取属性
        val ta = context.obtainStyledAttributes(attrs, R.styleable.SubButtonLayout)
        captionTextSize = ta.getDimension(R.styleable.SubButtonLayout_captionTextSize, defaultTextSizePx)
        captionTextColor = ta.getColor(R.styleable.SubButtonLayout_captionTextColor, 0)
        ta.recycle()
    }
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    private fun createTextView(notice: String) : TextView {
        val newTextView = TextView(context)
        newTextView.text = notice
        newTextView.textSize = Converter.px2sp(captionTextSize ?: defaultTextSizePx).toFloat()
        newTextView.setTextColor(captionTextColor ?: Color.DKGRAY)
        newTextView.visibility = View.INVISIBLE
        return newTextView
    }

    fun add(btn: FloatingActionButton, notice: String, resId: Int) {
        btn.setImageResource(resId)
        captionTextList.add(createTextView(notice))
        subButtonList.add(btn)
    }

    fun size(size: Int) : SubButtonLayout {
        return this
    }

    fun src(resIds: MutableList<Int>) : SubButtonLayout {
        for ((index, btn) in subButtonList.withIndex()) {
            btn.setImageResource(resIds[index])
        }
        return this
    }

    fun notice(notices: MutableList<String>) : SubButtonLayout {
        for (i in subButtonList.size..notices.size) {
            subButtonList.add(FloatingActionButton(context))
            captionTextList.add(createTextView(notices[i]))
        }
        return this
    }

}