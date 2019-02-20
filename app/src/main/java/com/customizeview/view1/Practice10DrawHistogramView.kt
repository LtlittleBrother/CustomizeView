package com.customizeview.view1

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画直方图
class Practice10DrawHistogramView :View{
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)


    override fun draw(canvas: Canvas?) {
        super.draw(canvas)
        val paint = Paint()
//        paint.isAntiAlias = true
        paint.style = Paint.Style.STROKE //设置绘制模式
        paint.color = Color.BLACK // 设置颜色

        canvas!!.drawLine(100f,50f,75f,75f,paint)
        canvas.run {
            drawLine(100f,50f,125f,75f,paint)
            drawLine(100f,50f,100f,800f,paint)
            drawLine(100f,800f,1000f,800f,paint)
            paint.textSize = 36f
            drawText("莽夫程度",125f,125f,paint)
            paint.style = Paint.Style.FILL
            paint.color = Color.GRAY
            drawRect(140f,760f,240f,800f,paint)
            drawText("Froyo",140f,840f,paint)
            paint.color = Color.RED
            drawRect(280f,380f,380f,800f,paint)
            drawText("GB",280f,840f,paint)
            paint.color = Color.GREEN
            drawRect(420f,400f,520f,800f,paint)
            drawText("ICS",420f,840f,paint)
            paint.color = Color.BLACK
            drawRect(560f,640f,660f,800f,paint)
            drawText("JB",560f,840f,paint)
            paint.color = Color.CYAN
            drawRect(700f,620f,800f,800f,paint)
            drawText("KitKat",700f,840f,paint)
            paint.color = Color.YELLOW
            drawRect(840f,520f,940f,800f,paint)
            drawText("L",840f,840f,paint)
        }
    }
}