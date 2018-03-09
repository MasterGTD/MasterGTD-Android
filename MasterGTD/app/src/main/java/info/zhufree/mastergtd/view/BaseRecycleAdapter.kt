package info.zhufree.mastergtd.view

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View

/**
 * Created by zhufree on 2018/3/8.
 * 各种Adapter基类
 */

abstract class BaseRecycleAdapter<T : Any>(context: Context, dataList: MutableList<T>)
    : RecyclerView.Adapter<BaseViewHolder>(), View.OnLongClickListener, View.OnClickListener {
    private var mOnItemClickListener: OnItemClickListener? = null
    private var mOnItemLongClickListener: OnItemLongClickListener? = null
    val mInflater: LayoutInflater = LayoutInflater.from(context)
    var mDataList = dataList
    var mItemViewList = emptyList<View>().toMutableList()

    //添加数据
    fun addItem(newList: List<T>) {
        mDataList.addAll(newList)
        notifyDataSetChanged()
    }

    // 更新数据
    fun refreshItem(newList: List<T>) {
        if (newList.isNotEmpty()) {
            mDataList.clear()
            mDataList.addAll(newList)
        }
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return mDataList.size
    }

    override fun onClick(v: View) {
        mOnItemClickListener?.onItemClick(v, v.tag as Int)
    }

    override fun onLongClick(v: View): Boolean {
        mOnItemLongClickListener?.onItemLongClick(v, v.tag as Int)
        return true
    }

    interface OnItemLongClickListener {
        fun onItemLongClick(view: View, position: Int)
    }

    interface OnItemClickListener {
        fun onItemClick(view: View, position: Int)
    }

    fun setOnItemLongClickListener(listener: OnItemLongClickListener) {
        this.mOnItemLongClickListener = listener
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.mOnItemClickListener = listener
    }

}
