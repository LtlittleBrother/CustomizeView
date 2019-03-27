package com.customizeview.activity

import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import com.customizeview.dialog.MoreDialog
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
                val dialog = MoreDialog(this@MainActivity)
                dialog.show()
            }
        })
    }


    private fun initChannelView(){
        tabAdapter = CustomizeViewTabFgAdapter(supportFragmentManager)
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

    private fun initChannerlUi(){
        mViewPager.currentItem = 0
        mViewPager.adapter = tabAdapter
        mTabLayout.setupWithViewPager(mViewPager)
    }

    override fun initUI() {
        mCommonTitleView.setLeftCloseIvVisibility(true)
        mCommonTitleView.setCenterTitleText("自定义 View 1-1 绘制基础")
        mCommonTitleView.setRightItemText("更多")
    }

    override fun initData() {
        initChannelView()
    }

    private fun setList(){
        mList.add("Practice01DrawColorView")
        mList.add("Practice02DrawCircleView")
        mList.add("Practice03DrawRectView")
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
