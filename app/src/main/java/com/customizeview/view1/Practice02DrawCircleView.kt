package com.customizeview.view1

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

//        练习内容：使用 canvas.drawCircle() 方法画圆
//        一共四个圆：1.实心圆 2.空心圆 3.蓝色实心圆 4.线宽为 20 的空心圆

class Practice02DrawCircleView :View{
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun draw(canvas: Canvas?) {
        super.draw(canvas)
        val paint = Paint()
        /**实心圆*/
        paint.style = Paint.Style.FILL //设置绘制模式
        paint.color = Color.BLACK // 设置颜色
        paint.isAntiAlias = true
        canvas!!.drawCircle(300f,200f,200f,paint)

        /**空心圆*/
        paint.style = Paint.Style.STROKE //设置绘制模式
        paint.color = Color.BLACK // 设置颜色
        canvas.drawCircle(800f,200f,200f,paint)

        /**蓝色实心圆*/
        paint.style = Paint.Style.FILL //设置绘制模式
        paint.color = Color.BLUE // 设置颜色
        canvas.drawCircle(300f,800f,200f,paint)

        /**线宽为 20 的空心圆*/
        paint.style = Paint.Style.STROKE
        paint.color = Color.BLUE
        paint.strokeWidth = 20f
        canvas.drawCircle(800f,800f,200f,paint)
    }
}