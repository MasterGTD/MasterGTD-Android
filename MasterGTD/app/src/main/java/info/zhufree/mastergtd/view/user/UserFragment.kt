package info.zhufree.mastergtd.view.user


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import info.zhufree.mastergtd.R
import info.zhufree.mastergtd.view.BaseFragment
import info.zhufree.mastergtd.view.todo.HabitFragment
import info.zhufree.mastergtd.view.todo.PercentFragment
import info.zhufree.mastergtd.view.todo.TodoViewPagerAdapter
import info.zhufree.mastergtd.view.todo.task.AllTaskFragment
import kotlinx.android.synthetic.main.fragment_user.*


/**
 * A simple [Fragment] subclass.
 * Use the [UserFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class UserFragment : BaseFragment() {
    private var fragmentList: MutableList<BaseFragment> = emptyList<BaseFragment>().toMutableList()
    private var titleList: MutableList<String> = emptyList<String>().toMutableList()

    companion object {
        // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//        private val ARG_PARAM1 = "param1"
//        private val ARG_PARAM2 = "param2"

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
//         * @param param1 Parameter 1.
//         * @param param2 Parameter 2.
         * @return A new instance of fragment BaseFragment.
         */
        // TODO: Rename and change types and number of parameters
        fun newInstance(/*param1: String, param2: String*/): UserFragment {
//            val fragment = UserFragment()
//            val args = Bundle()
//            args.putString(ARG_PARAM1, param1)
//            args.putString(ARG_PARAM2, param2)
//            fragment.arguments = args
            return UserFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        fragmentList.add(AllTaskFragment.newInstance())
        fragmentList.add(HabitFragment.newInstance())
        fragmentList.add(PercentFragment.newInstance())
        titleList.add("Task")
        titleList.add("习惯")
        titleList.add("进度")
        return inflater!!.inflate(R.layout.fragment_user, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        val todoViewPagerAdapter = TodoViewPagerAdapter(fragmentManager, fragmentList, titleList)
        vpTodo.adapter = todoViewPagerAdapter
        tabTodo.setupWithViewPager(vpTodo)
    }
}// Required empty public constructor
