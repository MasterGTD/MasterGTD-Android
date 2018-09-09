package info.zhufree.mastergtd.bean

import kotlinx.serialization.SerialName

/**
 * Created by Free on 2018/9/9.
 *
 */

data class TodoModel(@SerialName("todo_id") var id: String? = "",
                     @SerialName("todo_content") var content: String? = "",
                     @SerialName("todo_in_project") var projectName: String? = "",
                     @SerialName("todo_tag") var tag: String? = "",
                     @SerialName("todo_complete") var isComplete: Boolean? = false,
                     @SerialName("todo_create_at") var createdAt: String? = "2018-09-09T07:19:11.277Z",
                     @SerialName("todo_update_at") var updatedAt: String? = "2018-09-09T07:19:11.277Z",
                     @SerialName("todo_user") var userId: Int = -1)