package com.chenqiao.mvp

/**
 * Created by chenqiao on 2020-01-13.
 * e-mail : mrjctech@gmail.com
 */


interface IPresenter<out View: IMvpView<IPresenter<View>>>: ILifecycle{

    val view: View


}

interface IMvpView<out Presenter: IPresenter<IMvpView<Presenter>>>: ILifecycle{

    val  presenter: Presenter


}