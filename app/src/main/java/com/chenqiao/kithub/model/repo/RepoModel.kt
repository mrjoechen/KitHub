package com.chenqiao.kithub.model.repo

import com.bennyhuo.github.model.page.ListPage
import com.chenqiao.kithub.model.account.AccountManager
import com.chenqiao.kithub.network.entities.Repository
import com.chenqiao.kithub.network.entities.User
import com.chenqiao.kithub.network.services.RepositoryService
import com.chenqiao.kithub.utils.format
import retrofit2.adapter.rxjava.GitHubPaging
import rx.Observable
import java.util.*

class RepoListPage(val owner: User?): ListPage<Repository>(){
    override fun getData(page: Int): Observable<GitHubPaging<Repository>> {

        return if(owner == null){
            RepositoryService.allRepositories(page, "pushed:<" + Date().format("yyyy-MM-dd")).map { it.paging }
        } else {
            RepositoryService.listRepositoriesOfUser(owner.login, page)
        }
    }

}