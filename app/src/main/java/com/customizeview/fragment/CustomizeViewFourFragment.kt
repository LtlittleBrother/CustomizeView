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
import com.customizeview.view4.*


class CustomizeViewFourFragment : Fragment(){

    private val TAB_FRAGMENT_TYPE_DATA = "customize_view_four_fragment"

    private var mView: View? = null

    private var mIsPrepare: Boolean = false//视图还没准备好
    private var mIsVisible: Boolean = false//不可见
    private var mIsFirstLoad: Boolean = true//第一次加载

    private lateinit var data: String
    private lateinit var mTitle: TextView

    /**view*/
    private lateinit var clipRect: Practice01ClipRect
    private lateinit var clipPath: Practice02ClipPath
    private lateinit var translate: Practice03Translate
    private lateinit var rotate: Practice04Rotate
    private lateinit var scale: Practice05Scale
    private lateinit var skew: Practice06Skew

    fun newInstance(data: String): CustomizeViewFourFragment{
        val fragment = CustomizeViewFourFragment()
        val bundle = Bundle()
        bundle.putSerializable(TAB_FRAGMENT_TYPE_DATA,data)
        fragment.arguments = bundle
        return fragment
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val arguments = arguments
        data = arguments!!.getString(TAB_FRAGMENT_TYPE_DATA)
        if (mView == null){
            mView = inflater.inflate(R.layout.customize_view_four_fragment_layout,container,false)
        }
        findView(mView!!)
        return mView
    }

    @SuppressLint("SetTextI18n")
    fun findView(mView: View){
        mTitle = mView.findViewById(R.id.title_tv)
        when (data) {
            "Practice01ClipRect" -> {
                clipRect = mView.findViewById(R.id.practice_01_clip_rect)
                clipRect.visibility = View.VISIBLE
            }
            "Practice02ClipPath" ->{
                clipPath = mView.findViewById(R.id.practice_02_clip_path)
                clipPath.visibility = View.VISIBLE
            }
            "Practice03Translate" -> {
                translate = mView.findViewById(R.id.practice_03_translate)
                translate.visibility = View.VISIBLE
            }
            "Practice04Rotate" -> {
                rotate = mView.findViewById(R.id.practice_04_rotate)
                rotate.visibility = View.VISIBLE
            }
            "Practice05Scale" -> {
                scale = mView.findViewById(R.id.practice_05_cale)
                scale.visibility = View.VISIBLE
            }
            "Practice06Skew" -> {
                skew = mView.findViewById(R.id.practice_06_skew)
                skew.visibility = View.VISIBLE
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