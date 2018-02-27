package info.zhufree.mastergtd

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.design.widget.FloatingActionButton.SIZE_AUTO
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.View.GONE
import android.widget.LinearLayout
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import info.zhufree.mastergtd.view.explore.ExploreFragment
import info.zhufree.mastergtd.view.feed.FeedFragment
import info.zhufree.mastergtd.view.user.UserFragment
import info.zhufree.mastergtd.widget.MasterButton
import info.zhufree.mastergtd.widget.SubButton
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity() {
    @BindView(R.id.master_btn)
    lateinit var masterBtn: MasterButton
    @BindView(R.id.main_mask)
    lateinit var maskLayout: LinearLayout

    var feedFragment: FeedFragment? = null
    var exploreFragment: ExploreFragment? = null
    var userFragment: UserFragment? = null

    @OnClick(R.id.main_mask)
    fun hideMask(view: View) {
        view.visibility = GONE
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

        supportActionBar?.hide()

        feedFragment = FeedFragment()
        exploreFragment = ExploreFragment()
        userFragment = UserFragment()
        val transaction = fragmentManager.beginTransaction()
        transaction.add(R.id.frame_layout, feedFragment)
        transaction.commit()

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        masterBtn.setMask(maskLayout)
//        habit
        masterBtn.addSubBtn(SubButton(this).size(SIZE_AUTO).background(R.drawable.ic_timeline_white_24dp))
//                percent_todo
                .addSubBtn(SubButton(this).size(SIZE_AUTO).background(R.drawable.ic_hourglass_empty_white_24dp))
//                project
                .addSubBtn(SubButton(this).size(SIZE_AUTO).background(R.drawable.ic_list_white_24dp))
//                task
                .addSubBtn(SubButton(this).size(SIZE_AUTO).background(R.drawable.ic_note_add_white_24dp))
        masterBtn.setOnClickListener {
            masterBtn.clickBtn()
        }
    }
}
