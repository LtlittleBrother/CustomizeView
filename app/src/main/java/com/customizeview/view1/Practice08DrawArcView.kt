package com.customizeview.view1

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
//        练习内容：使用 canvas.drawArc() 方法画弧形和扇形
/**drawArc() 是使用一个椭圆来描述弧形的。left, top, right, bottom 描述的是这个弧形所在的椭圆；
 * startAngle 是弧形的起始角度（x 轴的正向，即正右的方向，是 0 度的位置；顺时针为正角度，逆时针为负角度），
 * sweepAngle 是弧形划过的角度；useCenter 表示是否连接到圆心，如果不连接到圆心，就是弧形，如果连接到圆心，就是扇形*/
class Practice08DrawArcView :View{
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun draw(canvas: Canvas?) {
        super.draw(canvas)
        val paint = Paint()
        paint.style = Paint.Style.FILL //设置绘制模式
        paint.isAntiAlias = true
        paint.color = Color.BLACK // 设置颜色
        canvas!!.drawArc(50f,50f,400f,200f,-60f,-60f,true,paint)//绘制扇形
        canvas.drawArc(50f,50f,400f,200f,20f,140f,false,paint)//绘制弧形
        paint.style = Paint.Style.STROKE
        canvas.drawArc(50f,50f,400f,200f,180f,50f,false,paint)//绘制不封口的弧形
        canvas.drawArc(50f,50f,400f,200f,10f,-40f,true,paint)//绘制不封口的扇形
    }
}