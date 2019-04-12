package com.customizeview.view3

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Typeface
import android.util.AttributeSet
import android.view.View

/**
 * setFakeBoldText(boolean fakeBoldText) 是否使用伪粗体
 * */
class Practice05SetFakeBoldTextView:View {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val paint = Paint()
        val text = "setFakeBoldText(boolean fakeBoldText) 是否使用伪粗体"
        paint.textSize = 30f
        paint.isFakeBoldText = false
        canvas!!.drawText(text,100f,200f,paint)

        paint.isFakeBoldText = true
        canvas.drawText(text,100f,400f,paint)
    }
}