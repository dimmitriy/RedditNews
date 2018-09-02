package news.reddit.com.redditnews;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

import news.reddit.com.redditnews.model.NewsListDataSource;
import news.reddit.com.redditnews.network.ServiceGenerator;
import news.reddit.com.redditnews.response.NewsEntity;

public class NewsViewModel extends AndroidViewModel {

    private LiveData<List<NewsEntity>> observable;

    public NewsViewModel(Application application) {
        super(application);
        observable = new NewsListDataSource(new ServiceGenerator().getNewsApiSet(application.getApplicationContext())).getNews("a");
    }

    public LiveData<List<NewsEntity>> getNews() {
        return observable;
    }
}
