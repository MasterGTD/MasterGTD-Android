package info.zhufree.mastergtd.view.todo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import info.zhufree.mastergtd.R
import info.zhufree.mastergtd.bean.TodoModel
import info.zhufree.mastergtd.service.HttpManager
import info.zhufree.mastergtd.widget.TODO_TYPE_TASK

class AddTodoActivity : AppCompatActivity() {
    private var todoType = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo)
        supportActionBar?.hide()

        todoType = intent.getIntExtra("TODO_TYPE", 0)
        val todo = TodoModel("", "create a todo", "", "api", false)
        HttpManager.instance.createTodo(todo)
        when (todoType) {
            TODO_TYPE_TASK -> AddTodoDialog().show(fragmentManager, "add Task")
        }
    }
}
