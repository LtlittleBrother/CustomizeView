package com.customizeview.activity

import android.content.Context
import android.content.Intent
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import com.customizeview.R
import com.customizeview.adapter.CustomizeViewSixFgAdapter
import com.customizeview.dialog.MoreDialog
import com.fiction.activity.BaseActivity
import com.fiction.view.CommonTitleView

class CustomizeViewSix: BaseActivity() {

    private lateinit var mCommonTitleView: CommonTitleView
    private lateinit var mTabLayout: TabLayout
    private lateinit var mViewPager: ViewPager
    private lateinit var tabAdapter: CustomizeViewSixFgAdapter
    private lateinit var mList: ArrayList<String>

    companion object {
        fun toCustomizeViewSix(context: Context): Intent {
            return Intent(context,CustomizeViewSix::class.java)
        }
    }

    override fun getLayoutResId(): Int {
        return R.layout.activity_customize_view_six
    }

    override fun findViews() {
        mCommonTitleView = findView(R.id.six_title_four)
        super.titleView = mCommonTitleView
        mTabLayout = findView(R.id.six_tab_layout_four)
        mViewPager = findView(R.id.six_view_page_four)

        mList = ArrayList()
    }

    override fun setEvent() {
        mCommonTitleView.setMainClickListener(object : CommonTitleView.OnMainClickListener{
            override fun onLeftClick() {
                finish()
            }

            override fun onRightClick() {
                val dialog = MoreDialog(this@CustomizeViewSix)
                dialog.show()
            }
        })
    }

    override fun initUI() {
        mCommonTitleView.setLeftCloseIvVisibility(true)
        mCommonTitleView.setCenterTitleText("自定义 View 1-1 绘制基础")
        mCommonTitleView.setRightItemText("更多")
    }

    private fun initChannelView(){
        tabAdapter = CustomizeViewSixFgAdapter(supportFragmentManager)
        initPageData()
        initChannerlUi()
    }

    private fun initPageData(){
        setList()
        if (mList.isNotEmpty()){
            for (str: String in mList){
                tabAdapter.add(str)
            }
        }
    }

    override fun initData() {
        initChannelView()
    }

    private fun initChannerlUi(){
        mViewPager.currentItem = 0
        mViewPager.adapter = tabAdapter
        mTabLayout.setupWithViewPager(mViewPager)
    }

    private fun setList(){
        mList.add("ViewPropertyAnimatorView")
        mList.add("ObjectAnimatorView")
        mList.add("InterpolatorView")
        mList.add("Practice04DrawPointView")
        mList.add("Practice05DrawOvalView")
        mList.add("Practice06DrawLineView")
        mList.add("Practice07DrawRoundRectView")
        mList.add("Practice08DrawArcView")
        mList.add("Practice09DrawPathView")
        mList.add("Practice10DrawHistogramView")
        mList.add("Practice11DrawPieChartView")
    }

}