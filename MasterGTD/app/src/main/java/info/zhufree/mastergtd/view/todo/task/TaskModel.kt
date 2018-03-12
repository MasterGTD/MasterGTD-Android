package info.zhufree.mastergtd.view.todo.task

import java.util.*

/**
 * Created by zhufree on 2018/3/12.
 * taskModel
 */

data class TaskModel(var name: String, var isFinished: Boolean = false, var desc: String,
                     var ofProject: String?, var ofList: String?, var isPublic: Boolean = true,
                     var startDay: Calendar, var endDay: Calendar?)