package info.zhufree.mastergtd.service

import info.zhufree.mastergtd.bean.TodoModel
import io.reactivex.Observable
import okhttp3.RequestBody
import retrofit2.http.*

/**
 * Created by Free on 2018/9/9.
 * 网络请求接口
 */

interface ApiService {

    // 用户名密码获取token
    @Headers(
            "Content-Type:application/json"
    )
    @POST("/users/obtain_token")
    fun getToken(@Body userBody: String): Observable<String>

    @Headers("Content-Type:application/json")
    @POST("/project/")
    fun createProject(@Body project: RequestBody): Observable<String>

    @Headers("Content-Type:application/json")
    @POST("/todo/")
    fun createTodo(@Body todo: RequestBody): Observable<String>
}