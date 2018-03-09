package info.zhufree.mastergtd

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AppCompatActivity
import android.view.View
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import info.zhufree.mastergtd.view.explore.ExploreFragment
import info.zhufree.mastergtd.view.feed.FeedFragment
import info.zhufree.mastergtd.view.todo.TodoActivity
import info.zhufree.mastergtd.view.user.UserFragment
import info.zhufree.mastergtd.widget.MasterButton
import info.zhufree.mastergtd.widget.SubButtonLayout
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity() {
    @BindView(R.id.master_btn)
    lateinit var masterBtn: MasterButton
    @BindView(R.id.sub_btn_container)
    lateinit var subBtnContainer: SubButtonLayout

    var feedFragment: FeedFragment? = null
    var exploreFragment: ExploreFragment? = null
    var userFragment: UserFragment? = null

    @OnClick(R.id.sub_btn_container)
    fun hideContainer(view: View) {
        masterBtn.hideSubBtn()
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_feed -> {
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
        ButterKnife.bind(this)
        masterBtn.show();
        supportActionBar?.hide()

        feedFragment = FeedFragment.newInstance()
        exploreFragment = ExploreFragment.newInstance()
        userFragment = UserFragment.newInstance()
        val transaction = fragmentManager.beginTransaction()
        if (!feedFragment!!.isAdded) {
            transaction.add(R.id.frame_layout, feedFragment)
            transaction.commit()
        }

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        masterBtn.setContainer(subBtnContainer)
        masterBtn.addSubBtn(this, 0, "习惯任务", R.drawable.ic_timeline_white_24dp)
        masterBtn.addSubBtn(this, 1, "进度任务", R.drawable.ic_hourglass_empty_white_24dp)
        masterBtn.addSubBtn(this, 2, "项目任务", R.drawable.ic_event_white_24dp)
        masterBtn.addSubBtn(this, 3, "清单", R.drawable.ic_list_white_24dp)
        masterBtn.addSubBtn(this, 4, "待办事项", R.drawable.ic_note_add_white_24dp)
        masterBtn.setOnClickListener {
            masterBtn.clickBtn()
        }
    }
}
