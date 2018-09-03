package news.reddit.com.redditnews

import android.arch.lifecycle.Observer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_news_list.*
import android.arch.lifecycle.ViewModelProviders
import news.reddit.com.redditnews.response.NewsEntity

class NewsListActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var adapter: NewsListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_list)

        adapter = NewsListAdapter(applicationContext!!, this)
        news.adapter = adapter

        val model = ViewModelProviders.of(this,
                NewsListViewModelFactory(application, NewsListDataSource(
                                ServiceGenerator.getNewsApiSet(application.applicationContext))))
                .get(NewsViewModel::class.java)
        observeViewModel(model)
    }

    private fun observeViewModel(viewModel: NewsViewModel) {
        viewModel.getNews()
                .observe(this,
                        Observer<List<NewsEntity>>  {
                            if (it != null) {
                                adapter.setResponse(it)
                            }
                        }
                )
    }

    override fun onClick(v: View?) {

    }

}
