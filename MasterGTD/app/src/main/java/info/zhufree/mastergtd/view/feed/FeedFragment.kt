package info.zhufree.mastergtd.view.feed


import android.app.Fragment
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.BindView
import butterknife.ButterKnife

import info.zhufree.mastergtd.R
import info.zhufree.mastergtd.view.BaseFragment
import kotlinx.android.synthetic.main.fragment_explore.view.*


/**
 * A simple [Fragment] subclass.
 * Use the [FeedFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FeedFragment : BaseFragment() {
    @BindView(R.id.rv_feed_list)
    lateinit var feedListView: RecyclerView

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val contentView = inflater!!.inflate(R.layout.fragment_feed, container, false)
        unBinder = ButterKnife.bind(this, contentView)
        contentView.rv_feed_list.
        return super.onCreateView(inflater, container, savedInstanceState)
    }
}// Required empty public constructor
