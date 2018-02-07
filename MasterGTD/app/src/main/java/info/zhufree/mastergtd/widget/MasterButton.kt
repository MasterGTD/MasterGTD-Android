package info.zhufree.mastergtd.widget

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.content.Context
import android.support.design.widget.FloatingActionButton
import android.util.AttributeSet
import android.widget.ImageButton

/**
 * Created by Free on 2018/2/3.
 *
 */

class MasterButton : FloatingActionButton {
    var todoBtn: ImageButton? = null
    var projectBtn: ImageButton? = null
    var habitBtn: ImageButton? = null
    var percentBtn: ImageButton? = null

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    open fun showSubBtn() {
        habitBtn = ImageButton(context)
        projectBtn = ImageButton(context)
        percentBtn = ImageButton(context)
        todoBtn = ImageButton(context)
        habitBtn?.x = this.x
        projectBtn?.x = this.x
        percentBtn?.x = this.x
        todoBtn?.x = this.x
        val widthHolder  = PropertyValuesHolder.ofInt("minimumWidth", 0, this.width)
        val heightHolder = PropertyValuesHolder.ofInt("minimumHeight", 0, this.height)
        val alphaHolder  = PropertyValuesHolder.ofInt("alpha", 0, 1)
        ObjectAnimator.ofPropertyValuesHolder(habitBtn, widthHolder, heightHolder, alphaHolder).setDuration(500).start()
        ObjectAnimator.ofPropertyValuesHolder(projectBtn, widthHolder, heightHolder, alphaHolder).setDuration(500).start()
        ObjectAnimator.ofPropertyValuesHolder(percentBtn, widthHolder, heightHolder, alphaHolder).setDuration(500).start()
        ObjectAnimator.ofPropertyValuesHolder(todoBtn, widthHolder, heightHolder, alphaHolder).setDuration(500).start()
        return
    }
}
