package info.zhufree.mastergtd.view.todo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import butterknife.ButterKnife
import info.zhufree.mastergtd.R

class TodoActivity : AppCompatActivity() {
    private var todoType = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        todoType = intent.getIntExtra("TODO_TYPE", 0)

        setContentView(R.layout.activity_todo)
        ButterKnife.bind(this)
    }
}
