package info.zhufree.mastergtd.view

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import info.zhufree.mastergtd.R

/**
 * Created by zhufree on 2018/3/8.
 * 各种Adapter基类
 */

class BaseAdapter(context: Context, viewHolder: BaseViewHolder) : RecyclerView.Adapter<BaseViewHolder>() {
    val mContext = context
    val inflater: LayoutInflater = LayoutInflater.from(context)

    class FeedViewHolder(itemView: View) : BaseViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): BaseViewHolder {
        val convertView = inflater.inflate(R.layout.item_feed, parent, false)
        return FeedViewHolder(convertView)
    }

    override fun getItemCount(): Int {
        return 1
    }

    override fun onBindViewHolder(holder: BaseViewHolder?, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
