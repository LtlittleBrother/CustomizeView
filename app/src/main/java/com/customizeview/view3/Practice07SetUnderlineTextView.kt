package com.customizeview.view3

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
/**
 * setUnderlineText(boolean underlineText) 是否加下划线。
 * */
class Practice07SetUnderlineTextView:View {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val paint = Paint()
        val text = "setUnderlineText(boolean underlineText) 是否加下划线"
        paint.textSize = 30f
        paint.isUnderlineText = false
        canvas!!.drawText(text,100f,200f,paint)

        paint.isUnderlineText = true
        canvas.drawText(text,100f,400f,paint)
    }
}