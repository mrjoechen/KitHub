package com.chenqiao.kithub.widget

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.graphics.Color
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.annotation.StringRes
import com.chenqiao.common.ext.dip


class ErrorInfoView(val parentView: ViewGroup):RelativeLayout(parentView.context){


    private var textView: TextView = TextView(parentView.context)

    init {
        setBackgroundColor(Color.WHITE)
        textView.textSize = 18f
        textView.setPadding(dip(5),dip(5),dip(5),dip(5))
        textView.setTextColor(Color.BLACK)
        textView.layoutParams = LayoutParams(width, height).apply { addRule(CENTER_IN_PARENT) }

    }

    var isShowing = false

    fun show(text: String) {
        if (!isShowing) {
            parentView.addView(this, LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)
            alpha = 0f
            animate().alpha(1f).setDuration(100).start()
            isShowing = true
        }
        textView.text = text
    }

    fun dismiss() {
        if (isShowing) {
            parentView.startViewTransition(this)
            parentView.removeView(this)
            animate().alpha(0f).setDuration(100).setListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator?) {
                    parentView.endViewTransition(this@ErrorInfoView)
                }
            }).start()
            isShowing = false
        }
    }

    fun show(@StringRes textRes: Int) {
        show(context.getString(textRes))
    }

}
