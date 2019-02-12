package com.customizeview.activity

import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import com.customizeview.R
import com.customizeview.adapter.CustomizeViewTabFgAdapter
import com.fiction.activity.BaseActivity
import com.fiction.view.CommonTitleView

class MainActivity : BaseActivity() {

    private lateinit var mCommonTitleView: CommonTitleView
    private lateinit var mTabLayout: TabLayout
    private lateinit var mViewPager: ViewPager
    private lateinit var tabAdapter: CustomizeViewTabFgAdapter
    private lateinit var mList: ArrayList<String>

    override fun getLayoutResId(): Int {
        return R.layout.activity_main
    }

    override fun findViews() {
        mCommonTitleView = findView(R.id.main_title)
        super.titleView = mCommonTitleView
        mTabLayout = findView(R.id.main_tab_layout)
        mViewPager = findView(R.id.main_view_page)

        mList = ArrayList()
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


    fun initChannelView(){
        tabAdapter = CustomizeViewTabFgAdapter(supportFragmentManager)
        initPageData()
        initChannerlUi()
    }

    fun initPageData(){
        setList()
        if (mList.isNotEmpty()){
            for (str: String in mList){
                tabAdapter.add(str)
            }
        }
    }

    fun initChannerlUi(){
        mViewPager.currentItem = 0
        mViewPager.adapter = tabAdapter
        mTabLayout.setupWithViewPager(mViewPager)
    }

    override fun initUI() {
        mCommonTitleView.setLeftCloseIvVisibility(true)
        mCommonTitleView.setCenterTitleText("自定义VIEW")
    }

    override fun initData() {
        initChannelView()
    }

    fun setList(){
        mList.add("DrawColorView")
        mList.add("DrawCircleView")
        mList.add("DrawRectView")
        mList.add("DrawPointView")
        mList.add("DrawOvalView")
        mList.add("DrawLineView")
        mList.add("DrawRoundRectView")
        mList.add("DrawArcView")
        mList.add("DrawPathView")
        mList.add("DrawHistogramView")
        mList.add("DrawPieChartView")
    }

}
