package com.customizeview.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.customizeview.R
import com.customizeview.activity.CustomizeViewFour
import com.customizeview.activity.CustomizeViewSix
import com.customizeview.activity.CustomizeViewThree
import com.customizeview.activity.CustomizeViewTwo
import com.fiction.util.ToastUtil

class MoreDialog: Dialog, View.OnClickListener{

    private var viewTwoTv: TextView? = null
    private var viewThreeTv: TextView? = null
    private var viewFourTv: TextView? = null
    private var animationTv: TextView? = null

    constructor(context: Context?) : super(context, R.style.custom_dialog_style)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.more_dialog_layout)
        viewTwoTv = findViewById(R.id.two_tv)
        viewThreeTv = findViewById(R.id.three_tv)
        viewFourTv = findViewById(R.id.four_tv)
        animationTv = findViewById(R.id.animation_tv)

        viewTwoTv!!.setOnClickListener(this)
        viewThreeTv!!.setOnClickListener(this)
        viewFourTv!!.setOnClickListener(this)
        animationTv!!.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        dismiss()
        when {
            v!!.id == R.id.two_tv -> context.startActivity(CustomizeViewTwo.toCustomizeViewTwo(context))
            v.id == R.id.three_tv -> CustomizeViewThree.toCustomizeViewThreePage(context)
            v.id == R.id.four_tv -> CustomizeViewFour.toCustomizeViewFourPage(context)
            v.id == R.id.animation_tv -> context.startActivity(CustomizeViewSix.toCustomizeViewSix(context))
        }
    }
}