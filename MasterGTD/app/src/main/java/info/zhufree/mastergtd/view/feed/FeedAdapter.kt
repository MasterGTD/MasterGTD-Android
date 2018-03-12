package info.zhufree.mastergtd.view.feed

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import butterknife.BindView
import info.zhufree.mastergtd.R
import info.zhufree.mastergtd.utils.Logger
import info.zhufree.mastergtd.view.BaseRecycleAdapter
import info.zhufree.mastergtd.view.BaseViewHolder

/**
 * Created by zhufree on 2018/3/8.
 *
 */

class FeedAdapter(context: Context, dataList: MutableList<String>)
        : BaseRecycleAdapter<String>(context, dataList) {

    class FeedViewHolder(itemView: View) : BaseViewHolder(itemView) {
        @BindView(R.id.tv_feed)
        lateinit var tvFeed: TextView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val convertView = mInflater.inflate(R.layout.item_feed, parent, false)
        return FeedViewHolder(convertView)
    }


    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        Logger.i(itemCount.toString())
        val feedHolder = holder as FeedViewHolder
        feedHolder.tvFeed.text = mDataList[position]
    }
}
