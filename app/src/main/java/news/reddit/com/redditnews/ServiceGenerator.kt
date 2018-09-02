package news.reddit.com.redditnews

import android.content.Context
import com.google.gson.GsonBuilder

import java.io.File
import java.util.concurrent.TimeUnit

import news.reddit.com.redditnews.api.NewsApiSet
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ServiceGenerator {

    companion object Factory {

        private const val BASE_API_URL = "https://www.reddit.com/r/php/"
        private const val DISK_CACHE_SIZE = 50 * 1024 * 1024
        private lateinit var build: Retrofit

        private fun getRetrofitInstance(context: Context): Retrofit {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY

            val builder = OkHttpClient.Builder()
            builder.connectTimeout(120, TimeUnit.SECONDS)
            builder.readTimeout(120, TimeUnit.SECONDS)
            builder.writeTimeout(120, TimeUnit.SECONDS)
            builder.addInterceptor(interceptor)

            val cacheDir = File(context.cacheDir, "cached")
            val cache = Cache(cacheDir, DISK_CACHE_SIZE.toLong())
            builder.cache(cache)
            val gson = GsonBuilder().create()

            val rxAdapter = RxJava2CallAdapterFactory.create()
            build = Retrofit.Builder()
                    .baseUrl(BASE_API_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addCallAdapterFactory(rxAdapter)
                    .build()

            return build
        }

        fun getNewsApiSet(context: Context): NewsApiSet {
            return getRetrofitInstance(context).create(NewsApiSet::class.java)
        }
    }

}

