package news.reddit.com.redditnews.model

import io.reactivex.Single
import news.reddit.com.redditnews.response.NewsListResponse

interface NewsListRepository {

    fun getNews(query: String): Single<NewsListResponse>

}