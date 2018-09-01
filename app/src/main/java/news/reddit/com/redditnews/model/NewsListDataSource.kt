package news.reddit.com.redditnews.model

import io.reactivex.Single
import news.reddit.com.redditnews.api.NewsApiSet
import news.reddit.com.redditnews.response.NewsListResponse

class NewsListDataSource(private val apiSet: NewsApiSet): NewsListRepository {

    override fun getNews(query: String): Single<NewsListResponse> {
        return apiSet.getNewList(query)
    }

}