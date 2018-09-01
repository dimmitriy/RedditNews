package news.reddit.com.redditnews.response

import java.util.*

class NewsEntityData(val author_fullname: String,
                     val title: String,
                     val author: String,
                     val num_comments: Int,
                     val permalink: String,
                     val url: String,
                     val subreddit_subscribers: Int,
                     val created_utc: Int)