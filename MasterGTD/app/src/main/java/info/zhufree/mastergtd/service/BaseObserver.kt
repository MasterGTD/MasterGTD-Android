package info.zhufree.mastergtd.service

import info.zhufree.mastergtd.utils.Logger
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

/**
 * Created by Free on 2018/9/9.
 *
 */
abstract class BaseObserver<T> : Observer<T> {

    override fun onComplete() {
    }

    override fun onSubscribe(d: Disposable) {
    }

    override fun onNext(t: T) {
    }

    override fun onError(e: Throwable) {
        Logger.i(e.localizedMessage, "observer")
    }
}