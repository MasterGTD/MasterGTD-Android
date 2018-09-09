package info.zhufree.mastergtd.bean

import kotlinx.serialization.SerialName

/**
 * Created by Free on 2018/9/9.
 *
 */

data class UserModel(@SerialName("username") var name: String? = "",
                    @SerialName("id") var id: Int? = -1,
                    @SerialName("user_info") var info: String? = "")