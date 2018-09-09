package info.zhufree.mastergtd.bean

import kotlinx.serialization.SerialName

/**
 * Created by Free on 2018/9/9.
 *
 */

data class ProjectModel(@SerialName("projects_id") var id: String? = "",
                        @SerialName("projects_name") var name: String? = "",
                        @SerialName("projects_info") var info: String? = "",
                        @SerialName("projects_complete") var isComplete: Boolean? = true,
                        @SerialName("projects_create_at") var createdAt: String? = "2018-09-09T07:27:58.351Z",
                        @SerialName("projects_update_at") var updatedAt: String? = "2018-09-09T07:27:58.351Z",
                        @SerialName("projects_user") var userId: Int? = -1)