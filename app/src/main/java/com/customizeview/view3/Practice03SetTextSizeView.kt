package com.customizeview.view3

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

/**
 * setTextSize(float textSize)设置文字大小
 * */
class Practice03SetTextSizeView:View {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val paint = Paint()
        val text = "Hello World!"
        paint.textSize = 30f
        canvas!!.drawText(text,100f,200f,paint)

        paint.textSize = 60f
        canvas.drawText(text,100f,400f,paint)

        paint.textSize = 90f
        canvas.drawText(text,100f,600f,paint)
    }
}