package com.customizeview.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.customizeview.R
import com.customizeview.activity.CustomizeViewFour
import com.customizeview.activity.CustomizeViewSix
import com.customizeview.activity.CustomizeViewThree
import com.customizeview.activity.CustomizeViewTwo
import com.customizeview.adapter.InterpolatorSelectorAdapter
import com.fiction.util.ToastUtil

class InterpolatorSelectorDialog: Dialog{

    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mAdapter: InterpolatorSelectorAdapter
    private lateinit var listener: OninterpolatorSelectorListener
    private lateinit var mList: ArrayList<String>

    constructor(context: Context?) : super(context, R.style.custom_dialog_style)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.interpolator_selector_dialog_layout)
        mRecyclerView = findViewById(R.id.recycle_view)
        mRecyclerView.layoutManager = LinearLayoutManager(context)
        mAdapter = InterpolatorSelectorAdapter()
        mRecyclerView.adapter = mAdapter
        setEvent()
        initData()
    }

    private fun initData() {
        mList = ArrayList()
        mList.add("AccelerateDecelerateInterpolator")
        mList.add("LinearInterpolator")
        mList.add("AccelerateInterpolator")
        mList.add("DecelerateInterpolator")
        mList.add("AnticipateInterpolator")
        mList.add("OvershootInterpolator")
        mList.add("AnticipateOvershootInterpolator")
        mList.add("BounceInterpolator")
        mList.add("CycleInterpolator")
        mList.add("PathInterpolator")
        mList.add("FastOutLinearInInterpolator")
        mList.add("FastOutSlowInInterpolator")
        mList.add("LinearOutSlowInInterpolator")
        mAdapter.setNewData(mList)
    }

    private fun setEvent() {
        mAdapter.setOnItemClickListener { adapter, view, position ->
            this.dismiss()
           listener.listener(position)
        }
    }


    fun setOninterpolatorSelectorListener(listener: OninterpolatorSelectorListener){
        this.listener = listener
    }

    interface OninterpolatorSelectorListener{
        fun listener(type: Int)
    }

}