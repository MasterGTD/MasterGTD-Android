package info.zhufree.mastergtd.view.feed


import android.app.Fragment
import android.content.Context
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.BindView
import butterknife.ButterKnife

import info.zhufree.mastergtd.R
import info.zhufree.mastergtd.utils.Logger
import info.zhufree.mastergtd.view.BaseFragment
import kotlinx.android.synthetic.main.fragment_feed.view.*


/**
 * A simple [Fragment] subclass.
 * Use the [FeedFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FeedFragment : BaseFragment() {
    var dataList = emptyList<String>().toMutableList()

    override fun onAttach(context: Context?) {
        Logger.i("onAttach")
        super.onAttach(context)
        dataList.add("test1")
        dataList.add("test2")
        dataList.add("test3")
        dataList.add("test4")
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val contentView = inflater!!.inflate(R.layout.fragment_feed, container, false)
        unBinder = ButterKnife.bind(this, contentView)

        val rvFeedRecyclerView = contentView.rv_feed_list
        rvFeedRecyclerView.adapter = FeedAdapter(context, dataList)
        val lm = LinearLayoutManager(context)
        lm.orientation = LinearLayoutManager.VERTICAL
        rvFeedRecyclerView.layoutManager = lm
        return contentView
    }
}// Required empty public constructor
