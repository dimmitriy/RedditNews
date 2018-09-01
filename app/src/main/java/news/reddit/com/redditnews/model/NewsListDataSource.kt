package news.reddit.com.redditnews.model

import io.reactivex.Single
import news.reddit.com.redditnews.response.NewsListResponse

class NewsListDataSource: NewsListRepository {

    override fun getNews(): Single<NewsListResponse> {
        return Single.fromCallable { null }
    }

}