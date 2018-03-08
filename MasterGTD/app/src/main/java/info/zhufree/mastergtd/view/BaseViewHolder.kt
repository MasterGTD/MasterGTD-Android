package info.zhufree.mastergtd.view

import android.support.v7.widget.RecyclerView
import android.view.View

/**
 * Created by zhufree on 2018/3/8.
 * ViewHolder基类
 */

abstract class BaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun initView(){}
}