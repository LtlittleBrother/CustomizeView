package com.customizeview.view3

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
/**
 * setTextSkewX(float skewX) 设置文字横向错切角度。其实就是文字倾斜度的啦。
 * */
class Practice08SetTextSkewXView:View {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val paint = Paint()
        val text = " setTextSkewX(float skewX) 设置文字横向错切角度。其实就是文字倾斜度的啦。"
        paint.textSize = 30f
        paint.textSkewX = -0.5f
        canvas!!.drawText(text,100f,200f,paint)

        paint.textSkewX = 0.5f
        canvas.drawText(text,100f,400f,paint)
    }
}