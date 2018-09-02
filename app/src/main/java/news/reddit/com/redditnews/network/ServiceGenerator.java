package news.reddit.com.redditnews.network;

import android.content.Context;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.util.concurrent.TimeUnit;

import news.reddit.com.redditnews.api.NewsApiSet;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {

    private final String BASE_API_URL = "https://www.reddit.com/r/php/";
    private final int DISK_CACHE_SIZE = 50 * 1024 * 1024;
    private Retrofit build;

    private Retrofit getRetrofitInstance(Context context) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(120, TimeUnit.SECONDS);
        builder.readTimeout(120, TimeUnit.SECONDS);
        builder.writeTimeout(120, TimeUnit.SECONDS);
        builder.addInterceptor(interceptor);

        File cacheDir = new File(context.getCacheDir(), "cached");
        Cache cache = new Cache(cacheDir, DISK_CACHE_SIZE);
        builder.cache(cache);
        Gson gson = new GsonBuilder().create();

        if (build == null) {
            RxJava2CallAdapterFactory rxAdapter = RxJava2CallAdapterFactory.create();
            build = new Retrofit.Builder()
                    .baseUrl(BASE_API_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addCallAdapterFactory(rxAdapter)
                    .build();
        }
        return build;
    }

    public NewsApiSet getNewsApiSet(Context context) {
        return new ServiceGenerator().getRetrofitInstance(context).create(NewsApiSet.class);
    }

}

