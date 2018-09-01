package com.example.moviereview.base

import android.content.Context

interface BaseView {

    fun showMessage(message: String)

    fun showProgress()

    fun hideProgress()

    fun getViewContext(): Context?

}
