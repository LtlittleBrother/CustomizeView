package com.customizeview.view3

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.graphics.Typeface
import android.util.AttributeSet
import android.view.View

/**
 *  setTypeface(Typeface typeface) 设置字体。
 * */
class Practice04SetTypefaceView:View {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val paint = Paint()
        val text = "setTypeface(Typeface typeface) 设置字体"
        paint.textSize = 30f
        paint.typeface = Typeface.DEFAULT
        canvas!!.drawText(text,100f,200f,paint)

        paint.typeface = Typeface.DEFAULT_BOLD
        canvas.drawText(text,100f,400f,paint)

        paint.typeface = Typeface.MONOSPACE
        canvas.drawText(text,100f,600f,paint)

        paint.typeface = Typeface.SERIF
        canvas.drawText(text,100f,800f,paint)
    }
}