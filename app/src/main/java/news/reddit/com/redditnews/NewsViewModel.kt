package news.reddit.com.redditnews

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData

import news.reddit.com.redditnews.response.NewsEntity

class NewsViewModel(application: Application, private val repository: NewsListRepository) : AndroidViewModel(application) {

    private var newsData: LiveData<List<NewsEntity>>? = null

    fun getNews(): LiveData<List<NewsEntity>> {
        if (newsData == null){
            newsData = MutableLiveData<List<NewsEntity>>()
            loadNews()
        }
        return newsData as LiveData<List<NewsEntity>>
    }

    private fun loadNews() {
        newsData = repository.getNews("a")
    }

}
