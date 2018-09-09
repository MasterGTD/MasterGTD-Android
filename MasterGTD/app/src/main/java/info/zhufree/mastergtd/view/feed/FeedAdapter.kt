package info.zhufree.mastergtd.view.feed

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import info.zhufree.mastergtd.R
import info.zhufree.mastergtd.utils.Logger
import info.zhufree.mastergtd.view.BaseAdapter
import info.zhufree.mastergtd.view.BaseViewHolder
import kotlinx.android.synthetic.main.item_feed.view.*

/**
 * Created by zhufree on 2018/3/8.
 *
 */

class FeedAdapter(context: Context, dataList: MutableList<String>)
        : BaseAdapter<FeedAdapter.FeedViewHolder, String>(context, dataList) {

    class FeedViewHolder(itemView: View) : BaseViewHolder(itemView) {
        fun setData(title: String) {
            itemView.tv_feed.text = title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {
        val convertView = LayoutInflater.from(mContext).inflate(R.layout.item_feed, parent, false)
        convertView?.setOnLongClickListener(this)
        convertView?.setOnClickListener(this)
        return FeedViewHolder(convertView)
    }


    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        Logger.i(itemCount.toString())
        val feedHolder = holder
        feedHolder.setData(dataList[position])
    }
}
