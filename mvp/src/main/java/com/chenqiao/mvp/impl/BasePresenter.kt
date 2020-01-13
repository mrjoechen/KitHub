package com.chenqiao.mvp.impl

import android.content.res.Configuration
import android.os.Bundle
import com.chenqiao.mvp.IMvpView
import com.chenqiao.mvp.IPresenter

/**
 * Created by chenqiao on 2020-01-13.
 * e-mail : mrjctech@gmail.com
 */


abstract class BasePresenter<out V: IMvpView<BasePresenter<V>>>: IPresenter<V>{


    override lateinit var view: @UnsafeVariance V

    override fun onCreate(savedInstanceState: Bundle?) = Unit

    override fun onSaveInstanceState(outState: Bundle) = Unit

    override fun onViewStateRestored(savedInstanceState: Bundle?) = Unit

    override fun onConfigurationChanged(newConfig: Configuration) = Unit

    override fun onDestroy() = Unit

    override fun onStart() = Unit

    override fun onStop() = Unit

    override fun onResume() = Unit

    override fun onPause() = Unit
}