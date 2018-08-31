package news.reddit.com.redditnews

class NewsListConract {

    internal interface View {

        fun onShowNewsList()

    }

    internal interface Presenter {

        fun onGetNewsTriggered()

    }

}
