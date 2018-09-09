package info.zhufree.mastergtd.service

import io.reactivex.Observable
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
    fun getScpSeriesModel(@Body userBody: String): Observable<String>
}