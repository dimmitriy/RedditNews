package news.reddit.com.redditnews.base

import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

interface BasePresenter {

    fun subscribe()

    fun unsubscribe()

    fun <T> adjustThreads(view: BaseView): ObservableTransformer<T, T> {
        return ObservableTransformer { upstream ->
            upstream
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .unsubscribeOn(Schedulers.io())
                    .doOnSubscribe { view.showProgress() }
                    .doAfterTerminate { view.hideProgress() }
        }
    }

}
