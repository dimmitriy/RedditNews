package news.reddit.com.redditnews

import com.example.moviereview.base.BasePresenter
import com.example.moviereview.base.BaseView
import news.reddit.com.redditnews.response.NewsEntity

class NewsListContract {

    interface View: BaseView {

        fun onShowNewsList(newsList: List<NewsEntity>)

    }

    interface Presenter: BasePresenter {

        fun onGetNewsTriggered(query: String)

    }

}
