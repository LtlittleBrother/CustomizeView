package com.customizeview.view2

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

/**用 Paint.setShader(shader) 设置一个 LinearGradient(线性渐变)
 * LinearGradient 的参数：坐标：(100, 100) 到 (500, 500) ；颜色：#E91E63 到 #2196F3*/

/**
 * 参数：
 * x0 y0 x1 y1：渐变的两个端点的位置
 * color0 color1 是端点的颜色
 * tile：端点范围之外的着色规则，类型是 TileMode。TileMode 一共有 3 个值可选： CLAMP, MIRROR 和  REPEAT
 * */
class Practice01LinearGradientView: View{
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun draw(canvas: Canvas?) {
        super.draw(canvas)
        val paint = Paint()
        val shader = LinearGradient(100f,200f,500f,200f,Color.parseColor("#E91E63")
        ,Color.parseColor("#2196F3"),Shader.TileMode.CLAMP)
        paint.shader = shader
        canvas!!.drawCircle(300f,200f,200f,paint)

        val shaderMirror = LinearGradient(600f,200f,1000f,200f,Color.parseColor("#E91E63")
                ,Color.parseColor("#2196F3"),Shader.TileMode.MIRROR)
        paint.shader = shaderMirror
        canvas.drawCircle(800f,200f,200f,paint)

        val shaderPepeat = LinearGradient(100f,800f,300f,800f,Color.parseColor("#E91E63")
                ,Color.parseColor("#2196F3"),Shader.TileMode.REPEAT)
        paint.shader = shaderPepeat
        canvas.drawCircle(300f,800f,200f,paint)

    }
}