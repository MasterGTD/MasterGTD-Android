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
import info.zhufree.mastergtd.widget.MasterButton
import info.zhufree.mastergtd.widget.SubButton
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    @BindView(R.id.master_btn)
    lateinit var masterBtn: MasterButton
    @BindView(R.id.main_mask)
    lateinit var maskLayout: LinearLayout

    @OnClick(R.id.main_mask)
    fun hideMask(view: View) {
        view.visibility = GONE
        masterBtn.hideSubBtn()
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                message.setText(R.string.tab_feed)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                message.setText(R.string.tab_mine)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                message.setText(R.string.tab_explore)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)
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
