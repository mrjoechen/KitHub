package com.chenqiao.kithub.view.common

import com.bennyhuo.tieguanyin.annotations.Builder
import com.bennyhuo.tieguanyin.annotations.Optional
import com.chenqiao.kithub.model.account.AccountManager
import com.chenqiao.kithub.network.entities.Repository
import com.chenqiao.kithub.network.entities.User
import com.chenqiao.kithub.view.presenter.RepoListPresenter
import com.chenqiao.kithub.view.presenter.RepoStarListPresenter


/**
 * Created by chenqiao on 2020-02-06.
 * e-mail : mrjctech@gmail.com
 */

@Builder
class RepoListFragment: CommonListFragment<Repository, RepoListPresenter>(){

//    @Optional
    var user: User? = AccountManager.currentUser

    override val adapter = RepoListAdapter()

}

@Builder
class RepoStarListFragment: CommonListFragment<Repository, RepoStarListPresenter>(){

    //    @Optional
    var user: User? = AccountManager.currentUser

    override val adapter = RepoListAdapter()

}