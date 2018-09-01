package news.reddit.com.redditnews

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import news.reddit.com.redditnews.model.NewsListDataSource
import news.reddit.com.redditnews.response.NewsEntity

class NewsListActivity : AppCompatActivity(), NewsListContract.View {

    lateinit var presenter: NewsListPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_list)
        presenter = NewsListPresenter(NewsListDataSource())
        presenter.onGetNewsTriggered()
    }

    override fun onShowNewsList(newsList: List<NewsEntity>) {

    }

    override fun showMessage(message: String) {

    }

    override fun showProgress() {

    }

    override fun hideProgress() {

    }

    override fun getViewContext(): Context? {
        return this
    }

}
