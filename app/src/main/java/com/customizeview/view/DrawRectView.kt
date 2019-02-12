package com.customizeview.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
//        练习内容：使用 canvas.drawRect() 方法画矩形
class DrawRectView : View{

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun draw(canvas: Canvas?) {
        super.draw(canvas)
        val paint = Paint()
        paint.style = Paint.Style.FILL
        paint.color = Color.BLACK
        paint.isAntiAlias = true // 抗锯齿
        canvas!!.drawRect(100f,100f,300f,300f,paint)

        paint.style = Paint.Style.STROKE
        paint.color = Color.BLACK
        canvas.drawRect(100f,400f,300f,600f,paint)
    }
}