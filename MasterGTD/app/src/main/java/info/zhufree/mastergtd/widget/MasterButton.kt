package info.zhufree.mastergtd.widget

import android.content.Context
import android.graphics.Color
import android.support.design.widget.FloatingActionButton
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.LinearLayout

/**
 * Created by Free on 2018/2/3.
 *
 */

class MasterButton : FloatingActionButton {
    var habitBtn: FloatingActionButton? = null
    var maskLayout: LinearLayout? = null
    var subBtnGroup: MutableList<SubButton> = emptyList<SubButton>().toMutableList()

    var isSubBtnShown = false

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

    fun showSubBtn() {
//        habitBtn = FloatingActionButton(context)
//        habitBtn?.x = this.x
//        habitBtn?.y = this.y - this.height - 20
//        habitBtn?.setBackgroundColor(Color.BLUE)
//        val parent = this.parent as ViewGroup
//        parent.addView(habitBtn)
//        habitBtn?.show()
//        val widthHolder  = PropertyValuesHolder.ofInt("minimumWidth", 0, this.width)
//        val heightHolder = PropertyValuesHolder.ofInt("minimumHeight", 0, this.height)
//        val alphaHolder  = PropertyValuesHolder.ofInt("alpha", 0, 1)
//        ObjectAnimator.ofPropertyValuesHolder(habitBtn, widthHolder, heightHolder, alphaHolder).setDuration(1000).start()
//        ObjectAnimator.ofPropertyValuesHolder(projectBtn, widthHolder, heightHolder, alphaHolder).setDuration(500).start()
//        ObjectAnimator.ofPropertyValuesHolder(percentBtn, widthHolder, heightHolder, alphaHolder).setDuration(500).start()
//        ObjectAnimator.ofPropertyValuesHolder(todoBtn, widthHolder, heightHolder, alphaHolder).setDuration(500).start()
//        先显示一个遮罩吧
        maskLayout?.visibility = View.VISIBLE
//        显示btn
        for ((index, btn) in subBtnGroup.withIndex()) {
            btn.x = this.x + (this.width - btn.width).div(2)
            btn.y = this.y - (100 + this.width) * index
        }
        isSubBtnShown = true
    }

    fun hideSubBtn() {
//        habitBtn?.hide()
        isSubBtnShown = false
    }
}
