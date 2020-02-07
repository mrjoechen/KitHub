package com.chenqiao.kithub.view.presenter

import com.chenqiao.kithub.model.repo.RepoListPage
import com.chenqiao.kithub.network.entities.Repository
import com.chenqiao.kithub.view.common.CommonListPresenter
import com.chenqiao.kithub.view.fragment.RepoListFragment

/**
 * Created by chenqiao on 2020-02-06.
 * e-mail : mrjctech@gmail.com
 */

class RepoListPresenter: CommonListPresenter<Repository, RepoListFragment>(){
    override val listPage by lazy {
        RepoListPage(view.user)
    }
}