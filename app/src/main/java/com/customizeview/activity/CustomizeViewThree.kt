package com.customizeview.activity

import android.content.Context
import android.content.Intent
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import com.customizeview.R
import com.customizeview.adapter.CustomizeViewThreeFgAdapter
import com.fiction.activity.BaseActivity
import com.fiction.view.CommonTitleView

class CustomizeViewThree : BaseActivity() {

    private lateinit var mCommonTitleView: CommonTitleView
    private lateinit var mViewPager: ViewPager
    private lateinit var mTabLayout: TabLayout

    private lateinit var tabAdapter: CustomizeViewThreeFgAdapter
    private lateinit var mList: ArrayList<String>

    companion object {
        fun toCustomizeViewThreePage(context: Context){
            val intent = Intent(context,CustomizeViewThree::class.java)
            context.startActivity(intent)
        }
    }

    override fun getLayoutResId(): Int {
        return R.layout.activity_customize_view_three
    }

    override fun findViews() {
        mCommonTitleView = findView(R.id.main_title_three)
        super.titleView = mCommonTitleView
        mViewPager = findView(R.id.main_view_page_three)
        mTabLayout = findView(R.id.main_tab_layout_three)
    }

    override fun setEvent() {
        mCommonTitleView.setMainClickListener(object : CommonTitleView.OnMainClickListener{
            override fun onLeftClick() {
                finish()
            }

            override fun onRightClick() {

            }
        })
    }

    override fun initUI() {
        mCommonTitleView.setLeftCloseIvVisibility(true)
        mCommonTitleView.setCenterTitleText("自定义 View 1-3 文字的绘制")
        mCommonTitleView.setRightItemText("更多")
    }

    override fun initData() {
        initChannelView()
    }

    private fun initChannelView(){
        tabAdapter = CustomizeViewThreeFgAdapter(supportFragmentManager)
        initPageData()
        initChannerlUi()
    }

    private fun initChannerlUi() {
        mViewPager.currentItem = 0
        mViewPager.adapter =tabAdapter
        mTabLayout.setupWithViewPager(mViewPager)
    }

    private fun initPageData() {
        setList()
        if (mList.isNotEmpty()){
            for (str: String in mList){
                tabAdapter.add(str)
            }
        }
    }

    private fun setList() {
        mList.add("Practice01DrawTextView")
        mList.add("Practice02StaticLayoutView")
        mList.add("Practice03SetTextSizeView")
        mList.add("Practice04SetTypefaceView")
        mList.add("Practice05SetFakeBoldTextView")
        mList.add("Practice06SetStrikeThruTextView")
        mList.add("Practice07SetUnderlineTextView")
        mList.add("Practice08SetTextSkewXView")
        mList.add("Practice09SetTextScaleXView")
        mList.add("Practice10SetTextAlignView")
        mList.add("Practice11GetFontSpacingView")
        mList.add("Practice12MeasureTextView")
        mList.add("Practice13GetTextBoundsView")
        mList.add("Practice14GetFontMetricsView")
    }

}
