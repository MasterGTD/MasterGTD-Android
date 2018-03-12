package info.zhufree.mastergtd.view.todo.task


import android.os.Bundle
import android.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.ButterKnife

import info.zhufree.mastergtd.R
import info.zhufree.mastergtd.view.BaseFragment
import kotlinx.android.synthetic.main.fragment_all_task.*


/**
 * A simple [Fragment] subclass.
 */
class AllTaskFragment : BaseFragment() {
    companion object {
        // TODO: Rename parameter arguments, choose names that match
        // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//        private val ARG_PARAM1 = "param1"
//        private val ARG_PARAM2 = "param2"

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HabitFragment.
         */
        // TODO: Rename and change types and number of parameters
        fun newInstance(/*param1: String, param2: String*/): AllTaskFragment {
            val fragment = AllTaskFragment()
//            val args = Bundle()
//            args.putString(ARG_PARAM1, param1)
//            args.putString(ARG_PARAM2, param2)
//            fragment.arguments = args
            return fragment
        }
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup,
                              savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        val contentView = inflater.inflate(R.layout.fragment_all_task, container, false)
        unBinder = ButterKnife.bind(this, contentView)
        taskRecyclerView?.adapter = AllTaskAdapter(context, mutableListOf())
        val lm = LinearLayoutManager(context)
        lm.orientation =  LinearLayoutManager.VERTICAL
        taskRecyclerView?.layoutManager = lm
        return contentView
    }
}// Required empty public constructor
