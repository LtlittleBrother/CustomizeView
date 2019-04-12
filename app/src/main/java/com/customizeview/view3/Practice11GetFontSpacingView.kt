package com.customizeview.view3

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
/**
 * float getFontSpacing()  获取推荐的行距
 * 即推荐的两行文字的 baseline 的距离。这个值是系统根据文字的字体和字号自动计算的。
 * 它的作用是当你要手动绘制多行文字（而不是使用 StaticLayout）的时候，可以在换行的时候给 y 坐标加上这个值来下移文字。
 * */
class Practice11GetFontSpacingView:View {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val paint = Paint()
        val text = arrayOf("float getFontSpacing()获取推荐的行距","即推荐的两行文字的 baseline 的距离",
               "这个值是系统根据文字的字体和字号自动计算的","它的作用是当你要手动绘制多行文字（而不是使用 StaticLayout）的时候"
        ,"可以在换行的时候给 y 坐标加上这个值来下移文字")
        paint.textSize = 30f
        canvas!!.drawText(text[0],100f,150f,paint)
        canvas.drawText(text[1],100f,150f+paint.fontSpacing,paint)
        canvas.drawText(text[2],100f,150f+paint.fontSpacing*2,paint)
        canvas.drawText(text[3],100f,150f+paint.fontSpacing*3,paint)
        canvas.drawText(text[4],100f,150f+paint.fontSpacing*4,paint)
    }
}