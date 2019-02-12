package com.customizeview.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
//        练习内容：使用 canvas.drawOval() 方法画椭圆
class DrawOvalView :View{
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun draw(canvas: Canvas?) {
        super.draw(canvas)
        val paint = Paint()
        /**实心椭圆*/
        paint.style = Paint.Style.FILL //设置绘制模式
        paint.color = Color.BLACK // 设置颜色
        paint.isAntiAlias = true
        canvas!!.drawOval(50f,50f,400f,200f,paint)

        /**空心椭圆*/
        paint.style = Paint.Style.STROKE
        canvas.drawOval(650f,50f,1000f,200f,paint)

    }
}