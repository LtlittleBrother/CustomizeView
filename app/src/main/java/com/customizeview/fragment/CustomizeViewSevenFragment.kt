package com.customizeview.fragment
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.customizeview.R
import com.customizeview.view7.PropertyValuesHolderView
import com.customizeview.view7.TypeEvaluatorView


class CustomizeViewSevenFragment : Fragment(){

    private val TAB_FRAGMENT_TYPE_DATA = "customize_view_two_fragment"

    private var mView: View? = null

    private var mIsPrepare: Boolean = false//视图还没准备好
    private var mIsVisible: Boolean = false//不可见
    private var mIsFirstLoad: Boolean = true//第一次加载

    private lateinit var data: String

    private lateinit var mStartTv: TextView

    private var type: Int = 0

    /**view*/
    private lateinit var typeEvaluatorView: TypeEvaluatorView
    private lateinit var propertyValuesHolderView: PropertyValuesHolderView

    fun newInstance(data: String): CustomizeViewSevenFragment{
        val fragment = CustomizeViewSevenFragment()
        val bundle = Bundle()
        bundle.putSerializable(TAB_FRAGMENT_TYPE_DATA,data)
        fragment.arguments = bundle
        return fragment
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val arguments = arguments
        data = arguments!!.getString(TAB_FRAGMENT_TYPE_DATA)
        if (mView == null){
            mView = inflater.inflate(R.layout.customize_view_seven_fragment_layout,container,false)
        }
        findView(mView!!)
        return mView
    }

    fun findView(mView: View){
        mStartTv = mView.findViewById(R.id.start_tv)
        when (data) {
            "TypeEvaluatorView" ->{
                typeEvaluatorView = mView.findViewById(R.id.type_evaluator_view)
                typeEvaluatorView.visibility = View.VISIBLE
            }
            "PropertyValuesHolderView" ->{
                propertyValuesHolderView = mView.findViewById(R.id.property_values_holder_view)
                propertyValuesHolderView.visibility = View.VISIBLE
            }
        }
        setEvent()
    }

    private fun setEvent() {
        mStartTv.setOnClickListener {
            event()
        }
    }

    fun event(){
        when (data) {
            "TypeEvaluatorView" ->{
                typeEvaluatorView.start()
            }
            "PropertyValuesHolderView" ->{
                propertyValuesHolderView.objectAnimatorStart()
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
        if (mIsPrepare && mIsVisible && !mIsFirstLoad){
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