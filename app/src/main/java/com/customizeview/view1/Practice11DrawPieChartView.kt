package com.customizeview.view1

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画饼图
class Practice11DrawPieChartView :View{
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun draw(canvas: Canvas?) {
        super.draw(canvas)
        var paint = Paint()
        paint.isAntiAlias = true
        paint.style = Paint.Style.FILL //设置绘制模式
        paint.color = Color.RED // 设置颜色
        canvas!!.run {
            drawArc(200f,200f,600f,600f,-45f,-150f,true,paint)
//            drawText("Lollipop",)
            paint.color  =Color.YELLOW
            drawArc(220f,220f,620f,620f,0f,-45f,true,paint)
            paint.color = Color.CYAN
            drawArc(220f,220f,620f,620f,5f,10f,true,paint)
            paint.color = Color.LTGRAY
            drawArc(220f,220f,620f,620f,20f,10f,true,paint)
            paint.color = Color.GREEN
            drawArc(220f,220f,620f,620f,33f,48f,true,paint)
            paint.color = Color.BLUE
            drawArc(220f,220f,620f,620f,82f,85f,true,paint)

//            paint.style = Paint.Style.STROKE
//            paint.strokeWidth = 10f
//            paint.color = Color.LTGRAY
//            drawLine(270f,245f,240f,200f,paint)
        }

    }
}