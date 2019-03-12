package com.customizeview.activity

import android.content.Context
import android.content.Intent
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import com.customizeview.R
import com.customizeview.adapter.CustomizeViewTwoFgAdapter
import com.fiction.activity.BaseActivity
import com.fiction.view.CommonTitleView

class CustomizeViewTwo: BaseActivity() {

    private lateinit var mCommonTitleView: CommonTitleView
    private lateinit var mTabLayout: TabLayout
    private lateinit var mViewPager: ViewPager
    private lateinit var tabAdapter: CustomizeViewTwoFgAdapter
    private lateinit var mList: ArrayList<String>

    companion object {
        fun toCustomizeViewTwo(context: Context):Intent{
            return Intent(context,CustomizeViewTwo::class.java)
        }
    }

    override fun getLayoutResId(): Int {
        return R.layout.customize_view_two_layout
    }

    override fun findViews() {
        mCommonTitleView = findView(R.id.two_title)
        super.titleView = mCommonTitleView
        mTabLayout = findView(R.id.two_tab_layout)
        mViewPager = findView(R.id.two_view_pager)
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

    override fun initUI() {
        mCommonTitleView.setCenterTitleText("自定义VIEW2")
    }

    override fun initData() {
        initChannelView()
    }

    private fun initChannelView(){
        tabAdapter = CustomizeViewTwoFgAdapter(supportFragmentManager)
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

    private fun setList(){
        mList.add("Practice00View")
        mList.add("Practice01LinearGradientView")
        mList.add("Practice02RadialGradientView")
        mList.add("Practice03SweepGradientView")
        mList.add("Practice04BitmapShaderView")
        mList.add("Practice05ComposeShaderView")
        mList.add("Practice06LightingColorFilterView")
        mList.add("Practice06PorterDuffColorFilter")
        mList.add("Practice07ColorMatrixColorFilterView")
        mList.add("Practice08XfermodeView")
        mList.add("Practice09StrokeCapView")
        mList.add("Practice10StrokeJoinView")
        mList.add("Practice11StrokeMiterView")
        mList.add("Practice12PathEffectView")
        mList.add("Practice13ShadowLayerView")
        mList.add("Practice14MaskFilterView")
        mList.add("Practice15FillPathView")
        mList.add("Practice16TextPathView")
    }

}