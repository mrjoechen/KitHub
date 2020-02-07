package com.chenqiao.kithub.view.common

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.chenqiao.kithub.R
import com.chenqiao.kithub.network.entities.Repository
import com.chenqiao.kithub.utils.loadWithGlide
import com.chenqiao.kithub.utils.toKilo
import kotlinx.android.synthetic.main.item_repo.view.*

class RepoListAdapter: CommonListAdapter<Repository>(R.layout.item_repo) {
    override fun onBindData(viewHolder: RecyclerView.ViewHolder, repository: Repository) {
        viewHolder.itemView.apply {

            avatarView.loadWithGlide(repository.owner.avatar_url, repository.owner.login.first())
            repoNameView.text = repository.name
            descriptionView.text = repository.description
            langView.text = repository.language ?: "Unknown"
            starView.text = repository.stargazers_count.toKilo()
            forkView.text = repository.forks_count.toKilo()
        }
    }

    override fun onItemClicked(itemView: View, item: Repository) {
//        itemView.startRepoDetailActivity(item)
    }

    override fun onItemClicked(itemView: View) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}