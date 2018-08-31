package news.reddit.com.redditnews

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class NewsListActivity : AppCompatActivity(), NewsListConract.View {

    lateinit var presenter: NewsListPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_list)
        presenter = NewsListPresenter()
        presenter.onGetNewsTriggered()
    }

    override fun onShowNewsList() {

    }

}
