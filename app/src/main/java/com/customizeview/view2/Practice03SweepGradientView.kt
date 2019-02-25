package com.customizeview.view2

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.SweepGradient
import android.util.AttributeSet
import android.view.View

/**
 * 用 Paint.setShader(shader) 设置一个 SweepGradient
 * SweepGradient 的参数：圆心坐标：(300, 300)；颜色：#E91E63 到 #2196F3
 * 构造方法SweepGradient(float cx, float cy, int color0, int color1)
 * cx cy ：扫描的中心
 * color0：扫描的起始颜色
 * color1：扫描的终止颜色
 * */
class Practice03SweepGradientView: View{
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun draw(canvas: Canvas?) {
        super.draw(canvas)
        val paint = Paint()
        paint.isAntiAlias = true
        val shader = SweepGradient(300f,300f,Color.parseColor("#E91E63"),
            Color.parseColor("#2196F3"))
        paint.shader = shader
        canvas!!.drawCircle(300f,300f,200f,paint)
    }
}