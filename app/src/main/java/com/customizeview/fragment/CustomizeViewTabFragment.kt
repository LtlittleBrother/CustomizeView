package com.customizeview.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.customizeview.R
import com.customizeview.view1.*


class CustomizeViewTabFragment : Fragment(){

    private val TAB_FRAGMENT_TYPE_DATA = "customize_view_tab_fragment"

    private var mView: View? = null

    private var mIsPrepare: Boolean = false//视图还没准备好
    private var mIsVisible: Boolean = false//不可见
    private var mIsFirstLoad: Boolean = true//第一次加载

    private lateinit var data: String
    private lateinit var mTitle: TextView

    /**view*/
    private lateinit var arcViewPractice08: Practice08DrawArcView
    private lateinit var circleViewPractice02: Practice02DrawCircleView
    private lateinit var colorViewPractice01: Practice01DrawColorView
    private lateinit var histogramViewPractice10: Practice10DrawHistogramView
    private lateinit var lineViewPractice06: Practice06DrawLineView
    private lateinit var ovalViewPractice05: Practice05DrawOvalView
    private lateinit var pathViewPractice09: Practice09DrawPathView
    private lateinit var pointViewPractice04: Practice04DrawPointView
    private lateinit var rectViewPractice03: Practice03DrawRectView
    private lateinit var roundRectViewPractice07: Practice07DrawRoundRectView
    private lateinit var pieChartViewPractice11: Practice11DrawPieChartView

    fun newInstance(data: String): CustomizeViewTabFragment{
        val fragment = CustomizeViewTabFragment()
        val bundle = Bundle()
        bundle.putSerializable(TAB_FRAGMENT_TYPE_DATA,data)
        fragment.arguments = bundle
        return fragment
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val arguments = arguments
        data = arguments!!.getString(TAB_FRAGMENT_TYPE_DATA)
        if (mView == null){
            mView = inflater.inflate(R.layout.customize_view_tab_fragment_layout,container,false)
        }
        findView(mView!!)
        return mView
    }

    @SuppressLint("SetTextI18n")
    fun findView(mView: View){
        mTitle = mView.findViewById(R.id.title_tv)
        when (data) {
            "Practice01DrawColorView" -> {
                mTitle.text = "练习内容：使用 canvas.drawColor() 方法把 View 涂成黄色"
                colorViewPractice01 = mView.findViewById(R.id.draw_color_view)
                colorViewPractice01.visibility = View.VISIBLE
            }
            "Practice02DrawCircleView" -> {
                mTitle.text = "练习内容：1.实心圆 2.空心圆 3.蓝色实心圆 4.线宽为 20 的空心圆"
                circleViewPractice02 = mView.findViewById(R.id.draw_circle_view)
                circleViewPractice02.visibility = View.VISIBLE
            }
            "Practice03DrawRectView" -> {
                mTitle.text = "练习内容：使用 canvas.drawRect() 方法画矩形"
                rectViewPractice03 = mView.findViewById(R.id.draw_rect_view)
                rectViewPractice03.visibility = View.VISIBLE
            }
            "Practice04DrawPointView" -> {
                mTitle.text = "一个圆点，一个方点"
                pointViewPractice04 = mView.findViewById(R.id.draw_point_view)
                pointViewPractice04.visibility = View.VISIBLE
            }
            "Practice05DrawOvalView" -> {
                mTitle.text = "练习内容：使用 canvas.drawOval() 方法画椭圆"
                ovalViewPractice05 = mView.findViewById(R.id.draw_oval_view)
                ovalViewPractice05.visibility = View.VISIBLE
            }
            "Practice06DrawLineView" -> {
                mTitle.text = "练习内容：使用 canvas.drawLine() 方法画直线"
                lineViewPractice06 = mView.findViewById(R.id.draw_line_view)
                lineViewPractice06.visibility = View.VISIBLE
            }
            "Practice07DrawRoundRectView" -> {
                mTitle.text = "练习内容：使用 canvas.drawRoundRect() 方法画圆角矩形"
                roundRectViewPractice07 = mView.findViewById(R.id.draw_round_rect_view)
                roundRectViewPractice07.visibility = View.VISIBLE
            }
            "Practice08DrawArcView" -> {
                mTitle.text = "练习内容：使用 canvas.drawArc() 方法画弧形和扇形"
                arcViewPractice08 = mView.findViewById(R.id.draw_arc_view)
                arcViewPractice08.visibility = View.VISIBLE
            }
            "Practice09DrawPathView" -> {
                mTitle.text = "练习内容：使用 canvas.drawPath() 方法画心形"
                pathViewPractice09 = mView.findViewById(R.id.draw_path_view)
                pathViewPractice09.visibility = View.VISIBLE
            }
            "Practice10DrawHistogramView" -> {
                mTitle.text = "练习内容：使用各种 Canvas.drawXXX() 方法画直方图"
                histogramViewPractice10 = mView.findViewById(R.id.draw_histogram_view)
                histogramViewPractice10.visibility = View.VISIBLE
            }
            "Practice11DrawPieChartView" -> {
                mTitle.text = "练习内容：使用各种 Canvas.drawXXX() 方法画饼图"
                pieChartViewPractice11 = mView.findViewById(R.id.draw_pie_chart_view)
                pieChartViewPractice11.visibility = View.VISIBLE
            }
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mIsPrepare = true
        lazyLoad()
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        //isVisibleToUser这个boolean值表示:该Fragment的UI 用户是否可见
        if (isVisibleToUser){
            mIsVisible = true
            lazyLoad()
        }else{
            mIsVisible = false
        }
        super.setUserVisibleHint(isVisibleToUser)
    }

    private fun lazyLoad(){
        if (mIsPrepare || mIsVisible || !mIsFirstLoad){
            return
        }
        loadData()
        //数据加载完毕,恢复标记,防止重复加载
        mIsFirstLoad = false
    }

    private fun loadData(){

    }

    override fun onDestroyView() {
        super.onDestroyView()
        //如果Fragment销毁的话，还应该将三个标志位进行默认值初始化：
        mIsFirstLoad = true
        mIsVisible = false
        mIsPrepare = false
        if (mView != null){
            (mView!!.parent as ViewGroup).removeView(mView)
        }
    }
}