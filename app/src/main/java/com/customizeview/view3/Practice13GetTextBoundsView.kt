package com.customizeview.view3

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View
/**
 * getTextBounds(String text, int start, int end, Rect bounds) 获取文字的显示范围
 * text 是要测量的文字，start 和 end 分别是文字的起始和结束位置，bounds 是存储文字显示范围的对象
 * ,方法在测算完成之后会把结果写进 bounds
 * */
class Practice13GetTextBoundsView:View {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val paint = Paint()
        val text = "getTextBounds()获取文字的显示范围"
        paint.textSize = 30f
        paint.style = Paint.Style.STROKE
        canvas!!.drawText(text,100f,200f,paint)
        val bounds = Rect()
        paint.getTextBounds(text,0,text.length,bounds)
        bounds.left += 100
        bounds.top += 200
        bounds.right += 100
        bounds.bottom += 200
        canvas.drawRect(bounds,paint)
    }
}