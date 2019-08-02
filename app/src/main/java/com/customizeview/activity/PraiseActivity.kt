package com.customizeview.activity

import android.content.Context
import android.content.Intent
import android.widget.TextView
import com.customizeview.NumScrollView
import com.customizeview.R
import com.fiction.activity.BaseActivity

class PraiseActivity: BaseActivity() {

    private lateinit var mNumScroll: NumScrollView
    private lateinit var mPraiseTv: TextView

    private var isPraise = true

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
        mNumScroll = findView(R.id.num_scroll_view)
        mPraiseTv = findView(R.id.praise_tv)
    }

    override fun setEvent() {
        mPraiseTv.setOnClickListener {
            mNumScroll.upDataNum(isPraise)
            isPraise = !isPraise
        }
    }

    override fun initUI() {

    }

    override fun initData() {

    }
}