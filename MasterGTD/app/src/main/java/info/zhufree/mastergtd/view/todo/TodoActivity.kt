package info.zhufree.mastergtd.view.todo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import info.zhufree.mastergtd.R
import info.zhufree.mastergtd.view.BaseFragment
import info.zhufree.mastergtd.view.todo.task.AllTaskFragment
import info.zhufree.mastergtd.widget.TODO_TYPE_TASK
import kotlinx.android.synthetic.main.activity_todo.*

class TodoActivity : AppCompatActivity() {
    private var fragmentList: MutableList<BaseFragment> = emptyList<BaseFragment>().toMutableList()
    private var titleList: MutableList<String> = emptyList<String>().toMutableList()
    private var todoType = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo)
        supportActionBar?.hide()

        todoType = intent.getIntExtra("TODO_TYPE", 0)

        fragmentList.add(AllTaskFragment.newInstance())
        fragmentList.add(HabitFragment.newInstance())
        fragmentList.add(PercentFragment.newInstance())
        titleList.add("Task")
        titleList.add("习惯")
        titleList.add("进度")

        val todoViewPagerAdapter = TodoViewPagerAdapter(fragmentManager, fragmentList, titleList)
        vpTodo.adapter = todoViewPagerAdapter
        tabTodo.setupWithViewPager(vpTodo)

        when (todoType) {
            TODO_TYPE_TASK -> AddTodoDialog().show(fragmentManager, "add Task")
        }
    }
}
