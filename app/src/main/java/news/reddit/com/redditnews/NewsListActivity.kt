package news.reddit.com.redditnews

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_news_list.*
import news.reddit.com.redditnews.model.NewsListDataSource
import news.reddit.com.redditnews.network.ServiceGenerator
import news.reddit.com.redditnews.response.NewsEntity

class NewsListActivity : AppCompatActivity(), NewsListContract.View, View.OnClickListener {

    private lateinit var presenter: NewsListPresenter
    private lateinit var adapter: NewsListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_list)
        presenter = NewsListPresenter(NewsListDataSource(ServiceGenerator.getNewsApiSet(applicationContext)))
        presenter.view = this
        presenter.onGetNewsTriggered("a")

        adapter = NewsListAdapter(applicationContext!!, this)
        news.adapter = adapter
    }

    override fun showProgress() {

    }

    override fun hideProgress() {

    }

    override fun getViewContext(): Context? {
        return this
    }

    override fun onShowNewsList(news: List<NewsEntity>) {
        adapter.setResponse(news)
    }

    override fun showMessage(message: String) {

    }

    override fun onClick(v: View?) {

    }

}
