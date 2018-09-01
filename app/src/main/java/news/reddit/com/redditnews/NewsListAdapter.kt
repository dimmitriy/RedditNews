package news.reddit.com.redditnews

import android.content.Context
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import news.reddit.com.redditnews.response.NewsEntity
import java.util.ArrayList

class NewsListAdapter(context: Context, private val listener: View.OnClickListener):
        RecyclerView.Adapter<NewsListAdapter.ViewHolder>() {

    private var radius = context.resources.getDimension(R.dimen.corner_radius_medium).toInt()
    private val glide = Glide.with(context)
    private val list = ArrayList<NewsEntity>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news_entity, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val newsEntity = list[position].data
        holder.tvTitle.text = newsEntity.title
        holder.tvVotesCount.text = newsEntity.num_comments.toString()
        val url = newsEntity.url
        if (!TextUtils.isEmpty(url)) {
            glide.load(url)
                    .apply(
                            RequestOptions()
                                    .transforms(CenterCrop(), RoundedCorners(radius))
                                    .error(R.drawable.news_item_placeholder))
                    .into(holder.imgPoster)
        }
        holder.view.setOnClickListener {
            listener.onClick(holder.view)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setResponse(results: List<NewsEntity>) {
        list.addAll(results)
        notifyDataSetChanged()
    }

    inner class ViewHolder(var view: View) : RecyclerView.ViewHolder(view) {
        var tvVotesCount = view.findViewById(R.id.tvVotesCount) as TextView
        var tvTitle = view.findViewById(R.id.tvTitleMessage) as TextView
        var tvPopularity = view.findViewById(R.id.tvPopularity) as TextView
        var tvOverview = view.findViewById(R.id.tvOverview) as TextView
        var imgPoster = view.findViewById(R.id.imgPoster) as ImageView
        var cvReminderMovies = view.findViewById(R.id.cvReminderMovies) as CardView
    }

}
