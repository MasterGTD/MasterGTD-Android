package info.zhufree.mastergtd.view.todo

import android.app.Fragment
import android.app.FragmentManager
import info.zhufree.mastergtd.utils.FragmentPagerAdapter
import info.zhufree.mastergtd.view.BaseFragment

/**
 * Created by zhufree on 2018/3/12.
 * todo_view_pager的fragmentPagerAdapter
 */

class TodoViewPagerAdapter(fragmentManager: FragmentManager, fragmentList: MutableList<BaseFragment>,
                           titleList: MutableList<String>) : FragmentPagerAdapter(fragmentManager) {
    private var mFragmentList: MutableList<BaseFragment> = fragmentList
    private var mTitleList: MutableList<String> = titleList
    override fun getItem(position: Int): Fragment {
        return mFragmentList[position]
    }

    override fun getCount(): Int {
        return mFragmentList.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return mTitleList[position]
    }

}