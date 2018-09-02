package news.reddit.com.redditnews

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData

import news.reddit.com.redditnews.response.NewsEntity

class NewsViewModel(application: Application, repository: NewsListRepository) : AndroidViewModel(application) {

    val news: LiveData<List<NewsEntity>> = repository.getNews("a")

}
