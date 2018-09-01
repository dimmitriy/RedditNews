package news.reddit.com.redditnews

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import news.reddit.com.redditnews.model.NewsListRepository

class NewsListPresenter(private val repository: NewsListRepository): NewsListContract.Presenter {

    lateinit var view: NewsListContract.View
    private val disposable = CompositeDisposable()

    override fun onGetNewsTriggered() {
        disposable.add(
                repository.getNews()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .unsubscribeOn(Schedulers.io())
                        .doOnSubscribe { view.showProgress() }
                        .doAfterTerminate { view.hideProgress() }
                        .subscribe({ response ->
                            view.onShowNewsList(response.data.children)
                        }, { throwable ->
                            view.showMessage(throwable.message!!)
                        })
        )
    }

    override fun subscribe() {

    }

    override fun unsubscribe() {
        disposable.dispose()
    }

}