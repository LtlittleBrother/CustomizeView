package com.customizeview.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.animation.FastOutLinearInInterpolator
import android.support.v4.view.animation.FastOutSlowInInterpolator
import android.support.v4.view.animation.LinearOutSlowInInterpolator
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.*
import android.widget.EditText
import android.widget.TextView
import com.customizeview.R
import com.customizeview.dialog.InterpolatorSelectorDialog
import com.customizeview.view6.InterpolatorView
import com.customizeview.view6.ObjectAnimatorView
import com.customizeview.view6.ViewPropertyAnimatorView


class CustomizeViewSixFragment : Fragment(){

    private val TAB_FRAGMENT_TYPE_DATA = "customize_view_two_fragment"

    private var mView: View? = null

    private var mIsPrepare: Boolean = false//视图还没准备好
    private var mIsVisible: Boolean = false//不可见
    private var mIsFirstLoad: Boolean = true//第一次加载

    private lateinit var data: String

    private lateinit var mStartTv: TextView
    private lateinit var mResetEt: EditText
    private lateinit var mUpdateType: TextView

    private var type: Int = 0

    /**view*/
    private lateinit var viewPropertyAnimatorView: ViewPropertyAnimatorView
    private lateinit var objectAnimatorView: ObjectAnimatorView
    private lateinit var interpolatorView: InterpolatorView

    fun newInstance(data: String): CustomizeViewSixFragment{
        val fragment = CustomizeViewSixFragment()
        val bundle = Bundle()
        bundle.putSerializable(TAB_FRAGMENT_TYPE_DATA,data)
        fragment.arguments = bundle
        return fragment
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val arguments = arguments
        data = arguments!!.getString(TAB_FRAGMENT_TYPE_DATA)
        if (mView == null){
            mView = inflater.inflate(R.layout.customize_view_six_fragment_layout,container,false)
        }
        findView(mView!!)
        return mView
    }

    @SuppressLint("SetTextI18n")
    fun findView(mView: View){
        mStartTv = mView.findViewById(R.id.start_tv)
        mResetEt = mView.findViewById(R.id.reset_et)
        mUpdateType = mView.findViewById(R.id.update_type)
        when (data) {
            "ViewPropertyAnimatorView" -> {
                mResetEt.hint = "请输入平移量"
                viewPropertyAnimatorView = mView.findViewById(R.id.view_property_animator_view)
                viewPropertyAnimatorView.visibility = View.VISIBLE
            }
            "ObjectAnimatorView" -> {
                mResetEt.hint = "请输入角度"
                objectAnimatorView = mView.findViewById(R.id.object_animator_view)
                objectAnimatorView.visibility = View.VISIBLE
            }
            "InterpolatorView" -> {
                mResetEt.hint = "请输入平移量"
                interpolatorView = mView.findViewById(R.id.interpolator_view)
                interpolatorView.visibility = View.VISIBLE
                mUpdateType.visibility = View.VISIBLE

            }
            "Practice03SweepGradientView" -> {

            }
            "Practice04BitmapShaderView" -> {

            }
            "Practice05ComposeShaderView" -> {

            }
            "Practice06LightingColorFilterView" -> {

            }
            "practice06PorterDuffColorFilter" -> {

            }
            "Practice07ColorMatrixColorFilterView" -> {

            }
            "Practice08XfermodeView" -> {

            }
            "Practice09StrokeCapView" -> {

            }
        }
        setEvent()
    }

    private fun setEvent() {
        mStartTv.setOnClickListener {
            event()
        }

        mUpdateType.setOnClickListener {
            val dialog  = InterpolatorSelectorDialog(context)
            dialog.setOninterpolatorSelectorListener(object : InterpolatorSelectorDialog.OninterpolatorSelectorListener{
                override fun listener(type: Int) {
                    this@CustomizeViewSixFragment.type = type
                }
            })
            dialog.show()
        }

    }

    fun event(){
        when (data) {
            "ViewPropertyAnimatorView" -> {
                viewPropertyAnimatorView.setTranX((mResetEt.text.toString()).toFloat())
            }
            "ObjectAnimatorView" -> {
//                objectAnimatorView.setEndAngle((mResetEt.text.toString()).toFloat())
                // 创建 ObjectAnimator 对象
                objectAnimatorView.start((mResetEt.text.toString()).toFloat())
            }
            "InterpolatorView" -> {
                interpolatorView.start((mResetEt.text.toString()).toFloat(),type)
            }
            "Practice03SweepGradientView" -> {

            }
            "Practice04BitmapShaderView" -> {

            }
            "Practice05ComposeShaderView" -> {

            }
            "Practice06LightingColorFilterView" -> {

            }
            "practice06PorterDuffColorFilter" -> {

            }
            "Practice07ColorMatrixColorFilterView" -> {

            }
            "Practice08XfermodeView" -> {

            }
            "Practice09StrokeCapView" -> {

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