package com.customizeview.activity

import android.content.Context
import android.content.Intent
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

    companion object {
        fun toCustomizeViewFourPage(context: Context){
            val intent = Intent(context,CustomizeViewFour::class.java)
            context.startActivity(intent)
        }
    }

    override fun getLayoutResId(): Int {
        return R.layout.activity_customize_view_four
    }

    override fun findViews() {
        mCommonTitleView = findView(R.id.six_title_four)
        super.titleView = mCommonTitleView
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
        mList = ArrayList()
        mList.add("Practice01ClipRect")
        mList.add("Practice02ClipPath")
        mList.add("Practice03Translate")
        mList.add("Practice04Rotate")
        mList.add("Practice05Scale")
        mList.add("Practice06Skew")
        mList.add("Practice07MatrixTranslate")
        mList.add("Practice08MatrixScale")
        mList.add("Practice09MatrixRotate")
        mList.add("Practice10MatrixSkew")
        mList.add("Practice11CameraRotate")
        mList.add("Practice12CameraRotateFixed")
        mList.add("Practice13CameraRotateHittingFace")
        mList.add("Practice14Flipboard")
        mList.add("SetPolyToPoly")
    }

}