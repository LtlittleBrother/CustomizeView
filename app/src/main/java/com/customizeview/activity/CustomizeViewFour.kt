package com.customizeview.activity

import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import com.customizeview.R
import com.customizeview.adapter.CustomizeViewFourFgAdapter
import com.fiction.activity.BaseActivity
import com.fiction.view.CommonTitleView

class CustomizeViewFour : BaseActivity(){

    private lateinit var mCommonTitleView: CommonTitleView
    private lateinit var mViewPager: ViewPager
    private lateinit var mTabLayout: TabLayout
    private lateinit var mList: ArrayList<String>

    private lateinit var tabAdapter: CustomizeViewFourFgAdapter

    override fun getLayoutResId(): Int {
        return R.layout.activity_customize_view_four
    }

    override fun findViews() {
        mCommonTitleView = findView(R.id.main_title_four)
        mViewPager = findView(R.id.main_view_page_four)
        mTabLayout = findView(R.id.main_tab_layout_four)

    }

    override fun setEvent() {

    }

    override fun initUI() {
        mCommonTitleView.setLeftCloseIvVisibility(true)
        mCommonTitleView.setCenterTitleText("自定义 View 1-4 Canvas 对绘制的辅助 ")
        mCommonTitleView.setRightItemText("更多")
    }

    override fun initData() {
        initChannelView()
    }

    private fun initChannelView(){
        tabAdapter = CustomizeViewFourFgAdapter(supportFragmentManager)
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
        mList.add("Practice01drawTextOnPath")
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