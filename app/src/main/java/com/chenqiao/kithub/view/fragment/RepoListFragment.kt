package com.chenqiao.kithub.view.fragment

import com.bennyhuo.tieguanyin.annotations.Builder
import com.bennyhuo.tieguanyin.annotations.Optional
import com.chenqiao.kithub.model.account.AccountManager
import com.chenqiao.kithub.network.entities.Repository
import com.chenqiao.kithub.network.entities.User
import com.chenqiao.kithub.view.common.CommonListFragment
import com.chenqiao.kithub.view.common.RepoListAdapter
import com.chenqiao.kithub.view.presenter.RepoListPresenter


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