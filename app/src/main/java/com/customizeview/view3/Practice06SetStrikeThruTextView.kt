package com.customizeview.view3

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
/**
 * setStrikeThruText(boolean strikeThruText)
 * 是否加删除线。
 * */
class Practice06SetStrikeThruTextView:View {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val paint = Paint()
        val text = "setStrikeThruText(boolean strikeThruText) 是否加删除线。"
        paint.textSize = 30f
        paint.isStrikeThruText = false
        canvas!!.drawText(text,100f,200f,paint)

        paint.isStrikeThruText = true
        canvas.drawText(text,100f,400f,paint)

    }
}