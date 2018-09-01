package news.reddit.com.redditnews.api

import io.reactivex.Single
import news.reddit.com.redditnews.response.NewsListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiSet {

    @GET("search.json")
    fun getNewList(@Query("q") query: String): Single<NewsListResponse>

}