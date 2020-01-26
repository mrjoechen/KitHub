package com.chenqiao.kithub.view

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.chenqiao.common.ext.log
import com.chenqiao.kithub.R

/**
 * Created by chenqiao on 2020-01-27.
 * e-mail : mrjctech@gmail.com
 */
class LoginActivity : AppCompatActivity() {

    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.tv)

        textView.setOnClickListener{
            log("test")
        }

    }
}