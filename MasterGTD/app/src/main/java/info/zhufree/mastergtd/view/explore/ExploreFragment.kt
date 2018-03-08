package info.zhufree.mastergtd.view.explore


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import info.zhufree.mastergtd.R
import info.zhufree.mastergtd.view.BaseFragment


/**
 * A simple [Fragment] subclass.
 * Use the [ExploreFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ExploreFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_explore, container, false)
    }
}// Required empty public constructor
