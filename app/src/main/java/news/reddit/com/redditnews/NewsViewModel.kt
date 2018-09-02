package news.reddit.com.redditnews

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData

import news.reddit.com.redditnews.model.NewsListDataSource
import news.reddit.com.redditnews.response.NewsEntity

class NewsViewModel(application: Application) : AndroidViewModel(application) {

    val news: LiveData<List<NewsEntity>> = NewsListDataSource(ServiceGenerator.getNewsApiSet(application.applicationContext)).getNews("a")

}
