package com.customizeview.view3

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
/**
 * setLetterSpacing(float letterSpacing) 设置字符间距。默认值是 0。
 * */
class Practice10SetTextAlignView:View {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val paint = Paint()
        val text = "setLetterSpacing(float letterSpacing) 设置字符间距。默认值是 0。"
        paint.textSize = 30f
        paint.letterSpacing = 0f
        canvas!!.drawText(text,100f,200f,paint)

        paint.letterSpacing = 0.5f
        canvas.drawText(text,100f,400f,paint)

        paint.letterSpacing = 1f
        canvas.drawText(text,100f,600f,paint)
    }
}