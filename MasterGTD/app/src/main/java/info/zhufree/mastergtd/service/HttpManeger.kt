package info.zhufree.mastergtd.service

import android.util.Log
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.jakewharton.retrofit2.converter.kotlinx.serialization.stringBased
import info.zhufree.mastergtd.bean.ProjectModel
import info.zhufree.mastergtd.bean.TodoModel
import info.zhufree.mastergtd.utils.GTDConstants
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.serialization.json.JSON
import okhttp3.MediaType
import retrofit2.Retrofit
import okhttp3.RequestBody



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
        apiService.getToken(username).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : BaseObserver<String>() {
                    override fun onNext(t: String) {
                        updateView(t)
                    }
                })
    }

    fun createTodo(todo: TodoModel) {
        val body = RequestBody.create(MediaType.parse("application/json"), todo.toString())
        apiService.createTodo(body).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : BaseObserver<String>() {
                    override fun onNext(t: String) {
                        Log.i("api", t)
                    }
                })
    }

    fun createProject(project: ProjectModel) {
        val body = RequestBody.create(MediaType.parse("application/json"), project.toString())
        apiService.createTodo(body).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : BaseObserver<String>() {
                    override fun onNext(t: String) {
                        Log.i("api", t)
                    }
                })
    }

    companion object {
        val instance = HttpManager()

    }
}