package com.chenqiao.kithub.view.common

import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.RecyclerView
import com.chenqiao.common.ext.dip
import com.chenqiao.kithub.R
import kotlinx.android.synthetic.main.item_card.view.*

/**
 * Created by chenqiao on 2020-02-05.
 * e-mail : mrjctech@gmail.com
 */
abstract class CommonListAdapter<T> (@LayoutRes val resId: Int) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    companion object {
        private const val CARD_TAP_DURATION = 100L
    }

    init {
        setHasStableIds(true)
    }

    private var oldPosition = -1


    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    val data = AdapterList<T>(this)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_card, parent, false)
        LayoutInflater.from(itemView.context).inflate(resId, itemView.contentContainer)

        itemView.setOnTouchListener { v, event ->
            when(event.action){

                MotionEvent.ACTION_DOWN -> ViewCompat.animate(itemView).scaleX(1.02f).scaleY(1.02f).translationZ(itemView.dip(10).toFloat()).duration = CARD_TAP_DURATION
                MotionEvent.ACTION_UP,
                MotionEvent.ACTION_CANCEL -> {
                    ViewCompat.animate(itemView).scaleX(1f).scaleY(1f).translationZ(itemView.dip(0).toFloat()).duration = CARD_TAP_DURATION
                }
            }

            false
        }

        itemView.setOnClickListener{
            //todo
//            onItemClicked(itemView, data[position])
            onItemClicked(itemView)
        }

        return CommonViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        onBindData(holder, data[position])
    }


    override fun getItemCount(): Int {
        return data.size
    }



    abstract fun onBindData(viewHolder: RecyclerView.ViewHolder, item: T)

    abstract fun onItemClicked(itemView: View, item: T)
    abstract fun onItemClicked(itemView: View)
    class CommonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}