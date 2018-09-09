package info.zhufree.mastergtd

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import info.zhufree.mastergtd.view.explore.ExploreFragment
import info.zhufree.mastergtd.view.feed.FeedFragment
import info.zhufree.mastergtd.view.user.UserFragment
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity() {
    private var feedFragment: FeedFragment? = null
    private var exploreFragment: ExploreFragment? = null
    private var userFragment: UserFragment? = null

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_feed -> {
                supportFragmentManager
                val transaction = fragmentManager.beginTransaction()
                transaction.replace(R.id.frame_layout, feedFragment)
                transaction.commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_user -> {
                val transaction = fragmentManager.beginTransaction()
                transaction.replace(R.id.frame_layout, userFragment)
                transaction.commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_explore -> {
                val transaction = fragmentManager.beginTransaction()
                transaction.replace(R.id.frame_layout, exploreFragment)
                transaction.commit()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        master_btn.show()
        supportActionBar?.hide()
        sub_btn_container.setOnClickListener {
            master_btn.hideSubBtn()
        }

        feedFragment = FeedFragment.newInstance()
        exploreFragment = ExploreFragment.newInstance()
        userFragment = UserFragment.newInstance()
        val transaction = fragmentManager.beginTransaction()
        if (!feedFragment!!.isAdded) {
            transaction.add(R.id.frame_layout, feedFragment)
            transaction.commit()
        }

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        master_btn.setContainer(sub_btn_container)
        master_btn.addSubBtn(this, 0, "习惯任务", R.drawable.ic_timeline_white_24dp)
        master_btn.addSubBtn(this, 1, "进度任务", R.drawable.ic_hourglass_empty_white_24dp)
        master_btn.addSubBtn(this, 2, "项目任务", R.drawable.ic_event_white_24dp)
        master_btn.addSubBtn(this, 3, "清单", R.drawable.ic_list_white_24dp)
        master_btn.addSubBtn(this, 4, "待办事项", R.drawable.ic_note_add_white_24dp)
        master_btn.setOnClickListener {
            master_btn.clickBtn()
        }
    }
}
