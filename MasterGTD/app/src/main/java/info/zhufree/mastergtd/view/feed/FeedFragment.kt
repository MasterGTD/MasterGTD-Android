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
    var dataList = mutableListOf<String>()

    companion object {
        // TODO: Rename parameter arguments, choose names that match
        // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
        private val ARG_PARAM1 = "param1"
        private val ARG_PARAM2 = "param2"

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BaseFragment.
         */
        // TODO: Rename and change types and number of parameters
        fun newInstance(/*param1: String, param2: String*/): FeedFragment {
//            val fragment = BaseFragment()
//            val args = Bundle()
//            args.putString(ARG_PARAM1, param1)
//            args.putString(ARG_PARAM2, param2)
//            fragment.arguments = args
            return FeedFragment()
        }
    }

    override fun onAttach(context: Context?) {
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
