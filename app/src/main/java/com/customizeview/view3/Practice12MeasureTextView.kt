package com.customizeview.view3

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
/**
 * FontMetircs getFontMetrics() 获取 Paint 的 FontMetrics
 * FontMetrics 是个相对专业的工具类，它提供了几个文字排印方面的数值：ascent, descent, top,  bottom, leading。
 * 1.baseline:前面已经讲过了，它的作用是作为文字显示的基准线
 * 2.ascent / descent: 它们的作用是限制普通字符的顶部和底部范围
 * 3.top / bottom: 它们的作用是限制所有字形（ glyph ）的顶部和底部范围
 * 除了普通字符，有些字形的显示范围是会超过 ascent 和 descent 的，而 top 和 bottom 则限制的是所有字形的显示范围，包括这些特殊字形
 * 4.leading 指的是行的额外间距，即对于上下相邻的两行，上行的 bottom 线和下行的 top 线的距离
 * */
class Practice12MeasureTextView:View {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val paint = Paint()
        val text = arrayOf("FontMetircs getFontMetrics() 获取 Paint 的 FontMetrics",
                "FontMetrics 是个相对专业的工具类，它提供了几个文字排印方面的数值：ascent, descent, top,  bottom, leading",
                "1.baseline:前面已经讲过了，它的作用是作为文字显示的基准线",
                "5.ascent / descent: 它们的作用是限制普通字符的顶部和底部范围",
                "3.top / bottom: 它们的作用是限制所有字形（ glyph ）的顶部和底部范围",
                "除了普通字符，有些字形的显示范围是会超过 ascent 和 descent 的，而 top 和 bottom 则限制的是所有字形的显示范围，包括这些特殊字形",
                "4.leading 指的是行的额外间距，即对于上下相邻的两行，上行的 bottom 线和下行的 top 线的距离")
        paint.textSize = 30f
        canvas!!.drawText(text[0],100f,150f,paint)
        canvas.drawText(text[1],100f,150f+paint.fontSpacing,paint)
        canvas.drawText(text[2],100f,150f+paint.fontSpacing*2,paint)
        canvas.drawText(text[3],100f,150f+paint.fontSpacing*3,paint)
        canvas.drawText(text[4],100f,150f+paint.fontSpacing*4,paint)
        canvas.drawText(text[5],100f,150f+paint.fontSpacing*5,paint)
        canvas.drawText(text[6],100f,150f+paint.fontSpacing*6,paint)
    }
}