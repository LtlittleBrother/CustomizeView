package com.customizeview.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
//        练习内容：使用 canvas.drawPoint() 方法画点
//        一个圆点，一个方点
//        圆点和方点的切换使用 paint.setStrokeCap(cap)：`ROUND` 是圆点，`BUTT` 或 `SQUARE` 是方点
class DrawPointView : View{

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun draw(canvas: Canvas?) {
        super.draw(canvas)
        val paint = Paint()
        paint.strokeWidth = 50f
        paint.strokeCap = Paint.Cap.BUTT // 端点为平头
        paint.color = Color.BLACK
        paint.isAntiAlias = true
        canvas!!.drawPoint(100f,100f,paint)

        paint.strokeCap = Paint.Cap.ROUND // 端点为圆头
        paint.color = Color.RED
        canvas.drawPoint(200f,100f,paint)

        paint.strokeCap = Paint.Cap.SQUARE // 端点为方头
        paint.color = Color.BLUE
        canvas.drawPoint(100f,200f,paint)
    }
}