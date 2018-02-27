package info.zhufree.mastergtd.widget

import android.content.Context
import android.support.design.widget.FloatingActionButton
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import android.widget.LinearLayout
import info.zhufree.mastergtd.utils.Converter
import info.zhufree.mastergtd.utils.Logger

/**
 * Created by Free on 2018/2/3.
 *
 */

class MasterButton : FloatingActionButton {
    private var maskLayout: LinearLayout? = null
    var subBtnGroup: MutableList<SubButton> = emptyList<SubButton>().toMutableList()


    private var isSubBtnShown = false

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    fun setMask(maskLayout: LinearLayout) {
        if (this.maskLayout == null) this.maskLayout = maskLayout
    }

    fun addSubBtn(subBtn: SubButton) : MasterButton {
        subBtnGroup.add(subBtn)
        return this
    }

    fun clickBtn() {
        when {
            isSubBtnShown -> hideSubBtn()
            else -> showSubBtn()
        }
    }

    private fun showSubBtn() {
        val parent = this.parent as ViewGroup
//        先显示一个遮罩吧
        maskLayout?.visibility = View.VISIBLE
//        旋转90度
        this.animate().setDuration(1000).rotationBy(45f)
//        显示btn
        for ((index, btn) in subBtnGroup.withIndex()) {
            if (btn.parent == null) parent.addView(btn)
            btn.x = this.x
            btn.y = this.y - (Converter.dp2px(16) + this.width) * (index+1)
            btn.visibility = View.INVISIBLE
        }
        subBtnGroup[0].viewTreeObserver.addOnGlobalLayoutListener (object : ViewTreeObserver.OnGlobalLayoutListener {
            override fun onGlobalLayout() {
                subBtnGroup[0].viewTreeObserver.removeOnGlobalLayoutListener(this)
//                只有在宽高大于0的情况下才会走动画显示
                Logger.i(subBtnGroup[0].width.toString())
                showNext(0)
            }

        })
        isSubBtnShown = true
    }

    fun showNext(position: Int) {
        subBtnGroup[position].show(object : OnVisibilityChangedListener() {
            override fun onShown(fab: FloatingActionButton?) {
                Logger.i(System.currentTimeMillis().toString())
                if (position + 1 < subBtnGroup.size) showNext(position +1)
            }
        })
    }

    fun hideSubBtn() {
        this.animate().setDuration(1000).rotationBy(-45f)
        hideNext(subBtnGroup.size - 1)
        isSubBtnShown = false
    }

    fun hideNext(position: Int) {
        subBtnGroup[position].hide(object : OnVisibilityChangedListener() {
            override fun onHidden(fab: FloatingActionButton?) {
                Logger.i(System.currentTimeMillis().toString())
                if (position - 1 >= 0) {
                    hideNext(position - 1)
                } else {
                    maskLayout?.visibility = View.GONE
                }
            }
        })
    }
}
