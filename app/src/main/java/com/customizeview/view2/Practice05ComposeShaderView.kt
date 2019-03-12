package com.customizeview.view2

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.customizeview.R


/**
 *  用 Paint.setShader(shader) 设置一个 ComposeShader
 *  Shader 1: BitmapShader 图片：R.drawable.batman
 *  Shader 2: BitmapShader 图片：R.drawable.batman_logo
 *  构造函数:ComposeShader(Shader shaderA, Shader shaderB, PorterDuff.Mode mode)
 *  参数：
 *  shaderA, shaderB：两个相继使用的 Shader
 *  mode: 两个 Shader 的叠加模式，即 shaderA 和 shaderB 应该怎样共同绘制。它的类型是 PorterDuff.Mode 。
 * */
class Practice05ComposeShaderView: View{
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun draw(canvas: Canvas?) {
        super.draw(canvas)
        val paint = Paint()
        // 第一个 Shader：头像的 Bitmap
        val bitmap1 = BitmapFactory.decodeResource(resources, R.drawable.draw_bitmp)
        val shader1 = BitmapShader(bitmap1, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)

        // 第二个 Shader：从上到下的线性渐变（由透明到黑色）
        val bitmap2 = BitmapFactory.decodeResource(resources, R.drawable.dianyou_red_long)
        val shader2 = BitmapShader(bitmap2, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)

        // ComposeShader：结合两个 Shader
        val shader = ComposeShader(shader1, shader2, PorterDuff.Mode.DST_IN)
        paint.shader = shader
        canvas!!.drawCircle(500f,500f,400f,paint)
    }
}