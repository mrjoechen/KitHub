package com.bennyhuo.github.model.page


import com.chenqiao.common.ext.logger
import com.chenqiao.kithub.view.page.DataProvider
import retrofit2.adapter.rxjava.GitHubPaging
import rx.Observable

abstract class ListPage<DataType>: DataProvider<DataType> {
    companion object {
        const val PAGE_SIZE = 20
    }

    var currentPage = 1
        private set

    val data = GitHubPaging<DataType>()

    fun loadMore() = getData(currentPage + 1)
            .doOnNext {
                currentPage + 1
            }
            .doOnError {
                logger.error("loadMore Error", it)
            }
            .map {
                data.mergeData(it)
                data
            }

    fun loadFromFirst(pageCount: Int = currentPage) =
            Observable.range(1, pageCount)
                    .concatMap {
                        getData(it)
                    }
                    .doOnError {
                        logger.error("loadFromFirst, pageCount=$pageCount", it)
                    }
                    .reduce { acc, page ->
                        acc.mergeData(page)
                    }
                    .doOnNext {
                        data.clear()
                        data.mergeData(it)
                    }
}