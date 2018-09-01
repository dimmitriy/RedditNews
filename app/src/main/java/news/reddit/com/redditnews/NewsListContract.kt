package news.reddit.com.redditnews

import news.reddit.com.redditnews.base.BasePresenter
import news.reddit.com.redditnews.base.BaseView
import news.reddit.com.redditnews.response.NewsEntity

class NewsListContract {

    interface View: BaseView {

        fun onShowNewsList(newsList: List<NewsEntity>)

    }

    interface Presenter: BasePresenter {

        fun onGetNewsTriggered(query: String)

    }

}
