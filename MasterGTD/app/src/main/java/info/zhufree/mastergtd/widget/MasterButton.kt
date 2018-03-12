package info.zhufree.mastergtd.widget

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.support.design.widget.FloatingActionButton
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import android.widget.RelativeLayout
import info.zhufree.mastergtd.R
import info.zhufree.mastergtd.utils.Converter
import info.zhufree.mastergtd.utils.Logger
import info.zhufree.mastergtd.view.todo.TodoActivity

/**
 * Created by Free on 2018/2/3.
 *
 */

const val TODO_TYPE_HABIT = 0
const val TODO_TYPE_PERCENT = 1
const val TODO_TYPE_PROJECT = 2
const val TODO_TYPE_CHECKLIST = 3
const val TODO_TYPE_TASK = 4


class MasterButton : FloatingActionButton {
    private var btnContainer: SubButtonLayout? = null
    private val intervalHeight = Converter.dp2px(16)

    private var isSubBtnShown = false

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    fun setContainer(btnContainer: SubButtonLayout) {
        if (this.btnContainer == null) this.btnContainer = btnContainer
    }

    fun addSubBtn(context: Context, type: Int, notice: String, resId: Int) : MasterButton {
        val fab = FloatingActionButton(context)
        fab.setOnClickListener {
            val intent = Intent(context, TodoActivity::class.java)
            intent.putExtra("TODO_TYPE", type)
            context.startActivity(intent)
        }
        btnContainer?.add(fab, notice, resId)

        return this
    }

    fun clickBtn() {
        when {
            isSubBtnShown -> hideSubBtn()
            else -> showSubBtn()
        }
    }

    private fun showSubBtn() {
        if (btnContainer?.subButtonList!!.size <= 0 || isSubBtnShown) return
        val halfHeight = height.div(2)
        val textSizePx = btnContainer?.captionTextList!![0].textSize
//        先显示容器
        btnContainer?.visibility = View.VISIBLE
//        旋转90度
        this.animate().setDuration(500).rotationBy(45f)
//        显示btn
        for ((index, btn) in btnContainer?.subButtonList!!.withIndex()) {

            if (btn.parent == null) {
                btnContainer?.addView(btn)
                btn.x = this.x
                btn.y = this.y - (intervalHeight + width) * (index+1)
                btn.visibility = View.INVISIBLE
                btn.viewTreeObserver.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
                    override fun onGlobalLayout() {
                        btn.viewTreeObserver.removeOnGlobalLayoutListener(this)
    //                只有在宽高大于0的情况下才会走动画显示
                        btn.show(object : OnVisibilityChangedListener() {
                            override fun onShown(fab: FloatingActionButton?) {
                                btnContainer?.captionTextList!![index].visibility = View.VISIBLE
                            }
                        })
                    }
                })
            } else {
                btn.show(object : OnVisibilityChangedListener() {
                    override fun onShown(fab: FloatingActionButton?) {
                        btnContainer?.captionTextList!![index].visibility = View.VISIBLE
                    }
                })
            }
        }

        for ((index, textView) in btnContainer?.captionTextList!!.withIndex()) {
            if (textView.parent == null) {
                btnContainer?.addView(textView)
                textView.x = x - textView.text.length * textSizePx - 50
                textView.y = y - (intervalHeight + width) * (index+1) + halfHeight - textSizePx/2
            }
        }

        isSubBtnShown = true
    }

    fun hideSubBtn() {
        if (!isSubBtnShown) return
        this.animate().setDuration(500).rotationBy(-45f)
        for ((index, btn) in btnContainer?.subButtonList!!.withIndex()) {
            btn.hide(object : OnVisibilityChangedListener() {
                override fun onHidden(fab: FloatingActionButton?) {
                    btnContainer?.visibility = GONE
                    btnContainer?.captionTextList!![index].visibility = View.GONE
                }
            })
            btnContainer?.captionTextList!![index].visibility = View.GONE
        }
        isSubBtnShown = false
    }
}
