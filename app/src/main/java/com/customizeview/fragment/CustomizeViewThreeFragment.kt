package com.customizeview.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.customizeview.R
import com.customizeview.view3.*


class CustomizeViewThreeFragment : Fragment(){

    private val TAB_FRAGMENT_TYPE_DATA = "customize_view_two_fragment"

    private var mView: View? = null

    private var mIsPrepare: Boolean = false//视图还没准备好
    private var mIsVisible: Boolean = false//不可见
    private var mIsFirstLoad: Boolean = true//第一次加载

    private lateinit var data: String
    private lateinit var mTitle: TextView

    /**view*/
    private lateinit var practice01DrawTextView: Practice01DrawTextView
    private lateinit var practice02StaticLayoutView: Practice02StaticLayoutView
    private lateinit var practice03SetTextSizeView: Practice03SetTextSizeView
    private lateinit var practice04SetTypefaceView: Practice04SetTypefaceView
    private lateinit var practice05SetFakeBoldTextView: Practice05SetFakeBoldTextView
    private lateinit var practice06SetStrikeThruTextView: Practice06SetStrikeThruTextView
    private lateinit var practice07SetUnderlineTextView: Practice07SetUnderlineTextView
    private lateinit var practice08SetTextSkewXView: Practice08SetTextSkewXView
    private lateinit var practice09SetTextScaleXView: Practice09SetTextScaleXView
    private lateinit var practice10SetTextAlignView: Practice10SetTextAlignView
    private lateinit var practice11GetFontSpacingView: Practice11GetFontSpacingView
    private lateinit var practice12MeasureTextView: Practice12MeasureTextView
    private lateinit var practice13GetTextBoundsView: Practice13GetTextBoundsView
    private lateinit var practice14GetFontMetricsView: Practice14GetFontMetricsView

    fun newInstance(data: String): CustomizeViewThreeFragment{
        val fragment = CustomizeViewThreeFragment()
        val bundle = Bundle()
        bundle.putSerializable(TAB_FRAGMENT_TYPE_DATA,data)
        fragment.arguments = bundle
        return fragment
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val arguments = arguments
        data = arguments!!.getString(TAB_FRAGMENT_TYPE_DATA)
        if (mView == null){
            mView = inflater.inflate(R.layout.customize_view_two_fragment_layout,container,false)
        }
        findView(mView!!)
        return mView
    }

    @SuppressLint("SetTextI18n")
    fun findView(mView: View){
        mTitle = mView.findViewById(R.id.title_tv)
        when (data) {
            "Practice01DrawTextView" -> {
                practice01DrawTextView = mView.findViewById(R.id.practice01_draw_text_view)
                practice01DrawTextView.visibility = View.VISIBLE
            }
            "Practice02StaticLayoutView" -> {
                practice02StaticLayoutView = mView.findViewById(R.id.practice02_static_layout_view)
                practice02StaticLayoutView.visibility = View.VISIBLE
            }
            "Practice03SetTextSizeView" -> {
                practice03SetTextSizeView = mView.findViewById(R.id.practice03_set_text_size_view)
                practice03SetTextSizeView.visibility = View.VISIBLE
            }
            "Practice04SetTypefaceView" -> {
                practice04SetTypefaceView = mView.findViewById(R.id.practice04_set_type_face_view)
                practice04SetTypefaceView.visibility = View.VISIBLE
            }
            "Practice05SetFakeBoldTextView" -> {
                practice05SetFakeBoldTextView = mView.findViewById(R.id.practice05_set_fake_bold_text_view)
                practice05SetFakeBoldTextView.visibility = View.VISIBLE
            }
            "Practice06SetStrikeThruTextView" -> {
                practice06SetStrikeThruTextView = mView.findViewById(R.id.practice06_set_strike_thru_text_view)
                practice06SetStrikeThruTextView.visibility = View.VISIBLE
            }
            "Practice07SetUnderlineTextView" -> {
                practice07SetUnderlineTextView = mView.findViewById(R.id.practice07_set_under_line_text_view)
                practice07SetUnderlineTextView.visibility = View.VISIBLE
            }
            "Practice08SetTextSkewXView" -> {
                practice08SetTextSkewXView = mView.findViewById(R.id.practice08_set_text_skew_x_view)
                practice08SetTextSkewXView.visibility = View.VISIBLE
            }
            "Practice09SetTextScaleXView" -> {
                practice09SetTextScaleXView = mView.findViewById(R.id.practice09_set_text_scale_x_view)
                practice09SetTextScaleXView.visibility = View.VISIBLE
            }
            "Practice10SetTextAlignView" -> {
                practice10SetTextAlignView = mView.findViewById(R.id.practice10_set_text_align_view)
                practice10SetTextAlignView.visibility = View.VISIBLE
            }
            "Practice11GetFontSpacingView" -> {
                practice11GetFontSpacingView = mView.findViewById(R.id.practice11_get_font_spacing_view)
                practice11GetFontSpacingView.visibility = View.VISIBLE
            }
            "Practice12MeasureTextView" -> {
                practice12MeasureTextView = mView.findViewById(R.id.practice12_measure_text_view)
                practice12MeasureTextView.visibility = View.VISIBLE
            }
            "Practice13GetTextBoundsView" -> {
                practice13GetTextBoundsView = mView.findViewById(R.id.practice13_get_text_bounds_view)
                practice13GetTextBoundsView.visibility = View.VISIBLE
            }
            "Practice14GetFontMetricsView" -> {
                practice14GetFontMetricsView = mView.findViewById(R.id.practice14_get_font_metrics_view)
                practice14GetFontMetricsView.visibility = View.VISIBLE
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