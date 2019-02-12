package com.customizeview.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.customizeview.R
import com.customizeview.view.*


class CustomizeViewTabFragment : Fragment(){

    private val TAB_FRAGMENT_TYPE_DATA = "customize_view_tab_fragment"

    private var mView: View? = null

    private var mIsPrepare: Boolean = false//视图还没准备好
    private var mIsVisible: Boolean = false//不可见
    private var mIsFirstLoad: Boolean = true//第一次加载

    private lateinit var data: String
    private lateinit var mTitle: TextView

    /**view*/
    private lateinit var arcView: DrawArcView
    private lateinit var circleViewView: DrawCircleView
    private lateinit var colorView: DrawColorView
    private lateinit var histogramView: DrawHistogramView
    private lateinit var lineView: DrawLineView
    private lateinit var ovalView: DrawOvalView
    private lateinit var pathView: DrawPathView
    private lateinit var pointView: DrawPointView
    private lateinit var rectView: DrawRectView
    private lateinit var roundRectView: DrawRoundRectView
    private lateinit var pieChartView: DrawPieChartView

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
        if (data == "DrawColorView"){
            mTitle.text = "练习内容：使用 canvas.drawColor() 方法把 View 涂成黄色"
            colorView = mView.findViewById(R.id.draw_color_view)
            colorView.visibility = View.VISIBLE
        }else if (data == "DrawCircleView"){
            mTitle.text = "练习内容：1.实心圆 2.空心圆 3.蓝色实心圆 4.线宽为 20 的空心圆"
            circleViewView = mView.findViewById(R.id.draw_circle_view)
            circleViewView.visibility = View.VISIBLE
        }else if (data == "DrawRectView"){
            mTitle.text = "练习内容：使用 canvas.drawRect() 方法画矩形"
            rectView = mView.findViewById(R.id.draw_rect_view)
            rectView.visibility = View.VISIBLE
        }else if (data == "DrawPointView"){
            mTitle.text = "一个圆点，一个方点"
            pointView = mView.findViewById(R.id.draw_point_view)
            pointView.visibility = View.VISIBLE
        }else if (data == "DrawOvalView"){
            mTitle.text = "练习内容：使用 canvas.drawOval() 方法画椭圆"
            ovalView = mView.findViewById(R.id.draw_oval_view)
            ovalView.visibility = View.VISIBLE
        }else if (data == "DrawLineView"){
            mTitle.text = "练习内容：使用 canvas.drawLine() 方法画直线"
            lineView = mView.findViewById(R.id.draw_line_view)
            lineView.visibility = View.VISIBLE
        }else if (data == "DrawRoundRectView"){
            mTitle.text = "练习内容：使用 canvas.drawRoundRect() 方法画圆角矩形"
            roundRectView = mView.findViewById(R.id.draw_round_rect_view)
            roundRectView.visibility = View.VISIBLE
        }else if (data == "DrawArcView"){
            mTitle.text = "练习内容：使用 canvas.drawArc() 方法画弧形和扇形"
            arcView = mView.findViewById(R.id.draw_arc_view)
            arcView.visibility = View.VISIBLE
        }else if (data == "DrawPathView"){
            mTitle.text = "练习内容：使用 canvas.drawPath() 方法画心形"
            pathView = mView.findViewById(R.id.draw_path_view)
            pathView.visibility = View.VISIBLE
        }else if (data == "DrawHistogramView"){
            mTitle.text = "练习内容：使用各种 Canvas.drawXXX() 方法画直方图"
            histogramView = mView.findViewById(R.id.draw_histogram_view)
            histogramView.visibility = View.VISIBLE
        }else if (data == "DrawPieChartView"){
            mTitle.text = "练习内容：使用各种 Canvas.drawXXX() 方法画饼图"
            pieChartView = mView.findViewById(R.id.draw_pie_chart_view)
            pieChartView.visibility = View.VISIBLE
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

    fun lazyLoad(){
        if (mIsPrepare || mIsVisible || !mIsFirstLoad){
            return
        }
        loadData()
        //数据加载完毕,恢复标记,防止重复加载
        mIsFirstLoad = false
    }

    fun loadData(){

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