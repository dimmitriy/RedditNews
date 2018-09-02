package news.reddit.com.redditnews

import android.annotation.SuppressLint
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import news.reddit.com.redditnews.api.NewsApiSet
import news.reddit.com.redditnews.response.NewsEntity

class NewsListDataSource(private val apiSet: NewsApiSet) : NewsListRepository {

    @SuppressLint("CheckResult")
    override fun getNews(query: String): LiveData<List<NewsEntity>> {
        val data = MutableLiveData<List<NewsEntity>>()
        apiSet.getNewList("a")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { response -> data.value = response.data.children },
                        { data.value = null }
                )
        return data
    }

}