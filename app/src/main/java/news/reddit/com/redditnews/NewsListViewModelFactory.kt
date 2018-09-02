package news.reddit.com.redditnews

import android.app.Application
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider

class NewsListViewModelFactory(private val application: Application, private val repository: NewsListRepository):
        ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>) = NewsViewModel(application, repository) as T

}
