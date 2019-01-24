package com.customizeview.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
//        练习内容：使用 canvas.drawLine() 方法画直线
class DrawLineView :View{
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun draw(canvas: Canvas?) {
        super.draw(canvas)
        var paint = Paint()
        paint.style = Paint.Style.FILL //设置绘制模式
        paint.color = Color.YELLOW // 设置颜色
        paint.strokeWidth = 12f // 设置线的宽度


    }
}