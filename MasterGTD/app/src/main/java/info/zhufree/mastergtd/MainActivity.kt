package info.zhufree.mastergtd

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.View.GONE
import android.widget.LinearLayout
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import info.zhufree.mastergtd.utils.Toaster
import info.zhufree.mastergtd.widget.MasterButton
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
        masterBtn.setOnClickListener {
            masterBtn.clickBtn()
            Toaster.show("test")
        }
    }
}
