package news.reddit.com.redditnews.model

import android.arch.lifecycle.LiveData
import news.reddit.com.redditnews.response.NewsEntity

interface NewsListRepository {

    fun getNews(query: String): LiveData<List<NewsEntity>>

}