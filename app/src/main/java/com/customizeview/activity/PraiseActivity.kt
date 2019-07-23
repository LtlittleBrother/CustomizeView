package com.customizeview.activity

import android.content.Context
import android.content.Intent
import com.customizeview.R
import com.fiction.activity.BaseActivity

class PraiseActivity: BaseActivity() {


    companion object {
        fun toPraiseActivityPage(context: Context){
            val intent = Intent(context,PraiseActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun getLayoutResId(): Int {
        return R.layout.praise_layout
    }

    override fun findViews() {

    }

    override fun setEvent() {

    }

    override fun initUI() {

    }

    override fun initData() {

    }
}