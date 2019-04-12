package com.customizeview.view3

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
/**
 * setTextScaleX(float scaleX) 设置文字横向放缩。也就是文字变胖变瘦。
 * */
class Practice09SetTextScaleXView:View {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val paint = Paint()
        val text = "setTextScaleX(float scaleX) 设置文字横向放缩。也就是文字变胖变瘦。"
        paint.textSize = 30f
        paint.textScaleX = 1f
        canvas!!.drawText(text,100f,200f,paint)

        paint.textScaleX = 0.5f
        canvas.drawText(text,100f,400f,paint)

        paint.textScaleX = 1.5f
        canvas.drawText(text,100f,600f,paint)
    }
}