package com.customizeview.view2

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View
/**
 * setStrokeMiter(float miter)
 * 这个方法是对于 setStrokeJoin() 的一个补充，它用于设置 MITER 型拐角的延长线的最大值
 *
 * */
class Practice11StrokeMiterView: View {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val paint = Paint()
        val path = Path()
        paint.strokeWidth = 50f
        paint.isAntiAlias = true
        path.moveTo(100f,100f)

        paint.strokeJoin = Paint.Join.MITER //尖角
//        当线条拐角为 MITER 时，拐角处的外缘需要使用延长线来补偿
        paint.strokeMiter = 45f
        paint.style = Paint.Style.STROKE
        path.lineTo(700f,100f)
        path.lineTo(200f,200f)
        canvas!!.drawPath(path,paint)
/**没懂到底啥意思*/
    }
}