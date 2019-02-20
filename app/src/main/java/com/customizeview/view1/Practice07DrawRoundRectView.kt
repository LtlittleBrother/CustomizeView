package com.customizeview.view1

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
//        练习内容：使用 canvas.drawRoundRect() 方法画圆角矩形
class Practice07DrawRoundRectView :View{
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun draw(canvas: Canvas?) {
        super.draw(canvas)
        var paint = Paint()
        paint.style = Paint.Style.FILL //设置绘制模式
        paint.isAntiAlias = true
        paint.color = Color.BLACK // 设置颜色
        canvas!!.drawRoundRect(50f,50f,400f,400f,30f,30f,paint)

        paint.style = Paint.Style.STROKE
        paint.color = Color.BLUE
        canvas.drawRoundRect(650f,50f,1000f,400f,30f,30f,paint)


    }
}