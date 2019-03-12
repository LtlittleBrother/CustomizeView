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
import com.customizeview.view2.*


class CustomizeViewTwoFragment : Fragment(){

    private val TAB_FRAGMENT_TYPE_DATA = "customize_view_two_fragment"

    private var mView: View? = null

    private var mIsPrepare: Boolean = false//视图还没准备好
    private var mIsVisible: Boolean = false//不可见
    private var mIsFirstLoad: Boolean = true//第一次加载

    private lateinit var data: String
    private lateinit var mTitle: TextView

    /**view*/
    private lateinit var practice00View: Practice00View
    private lateinit var practice01LinearGradientView: Practice01LinearGradientView
    private lateinit var practice02RadialGradientView: Practice02RadialGradientView
    private lateinit var practice03SweepGradientView: Practice03SweepGradientView
    private lateinit var practice04BitmapShaderView: Practice04BitmapShaderView
    private lateinit var practice05ComposeShaderView: Practice05ComposeShaderView
    private lateinit var practice06LightingColorFilterView: Practice06LightingColorFilterView
    private lateinit var practice06PorterDuffColorFilter: Practice06PorterDuffColorFilter
    private lateinit var practice07ColorMatrixColorFilterView: Practice07ColorMatrixColorFilterView
    private lateinit var practice08XfermodeView: Practice08XfermodeView
    private lateinit var practice09StrokeCapView: Practice09StrokeCapView
    private lateinit var practice10StrokeJoinView: Practice10StrokeJoinView
    private lateinit var practice11StrokeMiterView: Practice11StrokeMiterView
    private lateinit var practice12PathEffectView: Practice12PathEffectView
    private lateinit var practice13ShadowLayerView: Practice13ShadowLayerView
    private lateinit var practice14MaskFilterView: Practice14MaskFilterView
    private lateinit var practice15FillPathView: Practice15FillPathView
    private lateinit var practice16TextPathView: Practice16TextPathView

    fun newInstance(data: String): CustomizeViewTwoFragment{
        val fragment = CustomizeViewTwoFragment()
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
            "Practice00View" -> {
                practice00View = mView.findViewById(R.id.practice00_view)
                practice00View.visibility = View.VISIBLE
            }
            "Practice01LinearGradientView" -> {
                practice01LinearGradientView = mView.findViewById(R.id.linear_gradient_view)
                practice01LinearGradientView.visibility = View.VISIBLE
            }
            "Practice02RadialGradientView" -> {
                practice02RadialGradientView = mView.findViewById(R.id.radial_gradient_view)
                practice02RadialGradientView.visibility = View.VISIBLE
            }
            "Practice03SweepGradientView" -> {
                practice03SweepGradientView = mView.findViewById(R.id.sweep_gradient_view)
                practice03SweepGradientView.visibility = View.VISIBLE
            }
            "Practice04BitmapShaderView" -> {
                practice04BitmapShaderView = mView.findViewById(R.id.bitmap_shader_view)
                practice04BitmapShaderView.visibility = View.VISIBLE
            }
            "Practice05ComposeShaderView" -> {
                practice05ComposeShaderView = mView.findViewById(R.id.compose_shader_view)
                practice05ComposeShaderView.visibility = View.VISIBLE
            }
            "Practice06LightingColorFilterView" -> {
                practice06LightingColorFilterView = mView.findViewById(R.id.lighting_color_filter_view)
                practice06LightingColorFilterView.visibility = View.VISIBLE
            }
            "practice06PorterDuffColorFilter" -> {
                practice06PorterDuffColorFilter = mView.findViewById(R.id.porter_duff_color_filter)
                practice06PorterDuffColorFilter.visibility = View.VISIBLE
            }
            "Practice07ColorMatrixColorFilterView" -> {
                practice07ColorMatrixColorFilterView = mView.findViewById(R.id.color_matrix_color_filter_view)
                practice07ColorMatrixColorFilterView.visibility = View.VISIBLE
            }
            "Practice08XfermodeView" -> {
                practice08XfermodeView = mView.findViewById(R.id.xfermode_view)
                practice08XfermodeView.visibility = View.VISIBLE
            }
            "Practice09StrokeCapView" -> {
                practice09StrokeCapView = mView.findViewById(R.id.stroke_cap_view)
                practice09StrokeCapView.visibility = View.VISIBLE
            }
            "Practice10StrokeJoinView" -> {
                practice10StrokeJoinView = mView.findViewById(R.id.stroke_join_view)
                practice10StrokeJoinView.visibility = View.VISIBLE
            }
            "Practice11StrokeMiterView" -> {
                practice11StrokeMiterView = mView.findViewById(R.id.stroke_miter_view)
                practice11StrokeMiterView.visibility = View.VISIBLE
            }
            "Practice12PathEffectView" -> {
                practice12PathEffectView = mView.findViewById(R.id.path_effect_view)
                practice12PathEffectView.visibility = View.VISIBLE
            }
            "Practice13ShadowLayerView" -> {
                practice13ShadowLayerView = mView.findViewById(R.id.shadow_layer_view)
                practice13ShadowLayerView.visibility = View.VISIBLE
            }
            "Practice14MaskFilterView" -> {
                practice14MaskFilterView = mView.findViewById(R.id.mask_filter_view)
                practice14MaskFilterView.visibility = View.VISIBLE
            }
            "Practice15FillPathView" -> {
                practice15FillPathView = mView.findViewById(R.id.fill_path_view)
                practice15FillPathView.visibility = View.VISIBLE
            }
            "Practice16TextPathView" -> {
                practice16TextPathView = mView.findViewById(R.id.text_path_view)
                practice16TextPathView.visibility = View.VISIBLE
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