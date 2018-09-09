package info.zhufree.mastergtd.view.todo.task

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import info.zhufree.mastergtd.R
import info.zhufree.mastergtd.utils.Logger
import info.zhufree.mastergtd.view.BaseAdapter
import info.zhufree.mastergtd.view.BaseViewHolder
import kotlinx.android.synthetic.main.item_task.view.*

/**
 * Created by zhufree on 2018/3/12.
 *
 */

class AllTaskAdapter(context: Context, dataList: MutableList<TaskModel>)
    : BaseAdapter<AllTaskAdapter.TaskViewHolder, TaskModel>(context, dataList) {

    class TaskViewHolder(itemView: View) : BaseViewHolder(itemView) {
        fun setData(taskModel: TaskModel) {
            if (taskModel.isFinished) {
                itemView?.tickTask?.isChecked = true
            }
            itemView?.tvTaskDesc?.text = taskModel.name
            itemView?.tickTask?.setOnCheckedChangeListener{ _, isChecked ->
                if (isChecked) {
                    taskModel.isFinished = true
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val convertView = LayoutInflater.from(mContext).inflate(R.layout.item_task, parent, false)
        convertView?.setOnLongClickListener(this)
        convertView?.setOnClickListener(this)
        return TaskViewHolder(convertView)
    }


    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        Logger.i(itemCount.toString())
        holder.setData(dataList[position])


    }
}