package com.customizeview.view3

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View

/**
 * drawTextOnPath(String text, Path path, float hOffset, float vOffset, Paint paint)
 * 参数里，需要解释的只有两个： hOffset 和 vOffset。它们是文字相对于 Path 的水平偏移量和竖直偏移量，
 * 利用它们可以调整文字的位置。例如你设置 hOffset 为 5， vOffset 为 10，文字就会右移 5 像素和下移 10 像素。
 *
 * 沿着一条 Path 来绘制文字。这是一个耍杂技的方法。
 * */
class Practice01drawTextOnPath:View {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val paint = Paint()
        val path = Path()
        val text = "drawTextOnPath()  沿着一条 Path 来绘制文字。这是一个耍杂技的方法"
        paint.isAntiAlias = true
        paint.style = Paint.Style.STROKE
        path.addCircle(500f,300f,200f,Path.Direction.CW)
        canvas!!.drawPath(path,paint)

        val paintText = Paint()
        paintText.textSize = 30f
        paintText.color = Color.RED
        canvas.drawTextOnPath(text,path,0f,-20f,paintText)
    }
}