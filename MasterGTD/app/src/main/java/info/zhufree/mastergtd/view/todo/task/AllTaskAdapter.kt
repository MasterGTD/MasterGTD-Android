package info.zhufree.mastergtd.view.todo.task

import android.content.ClipDescription
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.TextView
import butterknife.BindView
import info.zhufree.mastergtd.R
import info.zhufree.mastergtd.utils.Logger
import info.zhufree.mastergtd.view.BaseRecycleAdapter
import info.zhufree.mastergtd.view.BaseViewHolder

/**
 * Created by zhufree on 2018/3/12.
 *
 */

class AllTaskAdapter(context: Context, dataList: MutableList<TaskModel>)
    : BaseRecycleAdapter<TaskModel>(context, dataList) {

    class TaskViewHolder(itemView: View) : BaseViewHolder(itemView) {
        @BindView(R.id.tickTask)
        lateinit var tickTask: CheckBox
        @BindView(R.id.tvTaskDesc)
        lateinit var taskDescTextView: TextView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val convertView = mInflater.inflate(R.layout.item_task, parent, false)
        return TaskViewHolder(convertView)
    }


    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        Logger.i(itemCount.toString())
        val taskHolder = holder as TaskViewHolder
        val taskModel = mDataList[position]
        if (taskModel.isFinished) {
            taskHolder.tickTask.isChecked = true
        }
        taskHolder.taskDescTextView.text = taskModel.name
        taskHolder.tickTask.setOnCheckedChangeListener{ _, isChecked ->
                    if (isChecked) {
                        taskModel.isFinished = true
                    }
                }

    }
}