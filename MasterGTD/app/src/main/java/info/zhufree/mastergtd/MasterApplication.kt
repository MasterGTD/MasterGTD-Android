package info.zhufree.mastergtd

import android.app.Application
import android.content.Context

/**
 * Created by Free on 2018/2/3.
 *
 */
class MasterApplication : Application() {

    companion object {
        var app: Context? = null
    }

    override fun onCreate() {
        super.onCreate()
        app = this
    }
}
