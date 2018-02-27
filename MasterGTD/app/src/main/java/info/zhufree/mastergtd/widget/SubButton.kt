package info.zhufree.mastergtd.widget

import android.content.Context
import android.support.design.widget.FloatingActionButton
import android.util.AttributeSet

/**
 * Created by zhufree on 2018/2/26.
 *
 */

class SubButton : FloatingActionButton {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    fun size(size: Int) : SubButton {
        super.setSize(size)
        return this
    }

    fun background(resId: Int) : SubButton {
        super.setBackgroundResource(resId)
        return this
    }
}