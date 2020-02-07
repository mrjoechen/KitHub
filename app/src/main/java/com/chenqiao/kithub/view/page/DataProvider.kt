package com.chenqiao.kithub.view.page

import retrofit2.adapter.rxjava.GitHubPaging
import rx.Observable

interface DataProvider<DataType> {
    fun getData(page: Int): Observable<GitHubPaging<DataType>>
}