package com.chenqiao.kithub.view

import android.content.Intent
import android.os.Bundle
import android.widget.*
import com.bennyhuo.tieguanyin.annotations.Builder
import com.chenqiao.common.ext.otherwise
import com.chenqiao.common.ext.yes
import com.chenqiao.kithub.R
import com.chenqiao.kithub.presenter.LoginPresenter
import com.chenqiao.kithub.utils.hideSoftInput
import com.chenqiao.mvp.impl.BaseActivity
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.app_bar_simple.*
import org.jetbrains.anko.toast
import kotlin.math.sin

/**
 * Created by chenqiao on 2020-01-27.
 * e-mail : mrjctech@gmail.com
 */

@Builder(flags = [Intent.FLAG_ACTIVITY_NO_HISTORY])
class LoginActivity : BaseActivity<LoginPresenter>() {


    //Kotlin Android Exception 可以自动生成 （导入 import kotlinx.android.synthetic.main.activity_login.*）
//    private val signInButton by lazy {
//        findViewById<Button>(R.id.signInButton)
//    }
//
//    private val userName by lazy {
//        findViewById<AutoCompleteTextView>(R.id.username)
//    }
//
//    private val password by lazy {
//        findViewById<EditText>(R.id.password)
//    }
//
//    private val loginForm by lazy {
//        findViewById<View>(R.id.loginForm)
//    }
//
//    private val loginProgress by lazy {
//        findViewById<ProgressBar>(R.id.loginProgress)
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setSupportActionBar(toolbar)

        signInButton.setOnClickListener {
            presenter.checkUsername(username.text.toString())
                .yes {
                    presenter.checkPassword(password.text.toString())
                        .yes {
                            hideSoftInput()
                            presenter.doLogin(username.text.toString(), password.text.toString())
                        }
                        .otherwise {
                            showTips(password, "密码不合法！")
                        }
                }
                .otherwise {
                    showTips(username, "用户名不合法！")
                }
        }

    }


    private fun showProgress(show: Boolean) {

    }

    private fun showTips(view: EditText, tips: String){
        view.requestFocus()
        view.error = tips
    }

    fun onLoginStart(){
        showProgress(true)
    }

    fun onLoginError(e: Throwable){
        e.printStackTrace()
        toast("登录失败")
        showProgress(false)
    }

    fun onLoginSuccess(){
        toast("登录成功")
        showProgress(false)
    }

    fun onDataInit(name: String, passwd: String){
        username.setText(name)
        password.setText(passwd)
    }

}