package info.zhufree.mastergtd.service

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.jakewharton.retrofit2.converter.kotlinx.serialization.stringBased
import info.zhufree.mastergtd.utils.GTDConstants
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.serialization.json.JSON
import okhttp3.MediaType
import retrofit2.Retrofit

/**
 * Created by Free on 2018/9/9.
 */

class HttpManager {
    private val TAG = javaClass.name

    val contentType = MediaType.parse("application/json")!!
    val json = JSON
    private val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(GTDConstants.API_BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(stringBased(contentType, json::parse, json::stringify))
            .build()
    private val apiService = retrofit.create(ApiService::class.java)
    //
    fun getToken(username: String, password: String, updateView: (token: String) -> Unit) {
        apiService.getScpSeriesModel(username).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : BaseObserver<String>() {
                    override fun onNext(t: String) {
                        updateView(t)
                    }
                })
    }
}