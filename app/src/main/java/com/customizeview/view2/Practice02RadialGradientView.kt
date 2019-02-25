package com.customizeview.view2

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

/**
 * 用 Paint.setShader(shader) 设置一个 RadialGradient
 * RadialGradient 的参数：圆心坐标：(300, 300)；半径：200；颜色：#E91E63 到 #2196F3
 * */

/**
 * 构造方法：
 * RadialGradient(float centerX, float centerY, float radius, int centerColor, int edgeColor, TileMode tileMode)。
 *
 * 参数：
 * centerX centerY：辐射中心的坐标
 * radius：辐射半径
 * centerColor：辐射中心的颜色
 * edgeColor：辐射边缘的颜色
 * tileMode：辐射范围之外的着色模式。
 * */
class Practice02RadialGradientView: View{
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun draw(canvas: Canvas?) {
        super.draw(canvas)
        val paint = Paint()
        val shaderClamp = RadialGradient(300f,300f,200f,Color.parseColor("#E91E63"),
                Color.parseColor("#2196F3"),Shader.TileMode.CLAMP)
        paint.shader = shaderClamp
        canvas!!.drawCircle(300f,300f,200f,paint)

        val shaderMirror = RadialGradient(800f,300f,200f,Color.parseColor("#E91E63"),
            Color.parseColor("#2196F3"),Shader.TileMode.MIRROR)
        paint.shader = shaderMirror
        canvas.drawCircle(800f,300f,200f,paint)

        val shaderPepeat = RadialGradient(300f,800f,200f,Color.parseColor("#E91E63"),
            Color.parseColor("#2196F3"),Shader.TileMode.REPEAT)
        paint.shader = shaderPepeat
        canvas.drawCircle(300f,800f,200f,paint)

    }
}