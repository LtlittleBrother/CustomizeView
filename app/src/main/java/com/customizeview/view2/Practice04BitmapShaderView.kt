package com.customizeview.view2

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.customizeview.R

/**
 * 用 Paint.setShader(shader) 设置一个 BitmapShader
 * Bitmap: R.drawable.batman
 * 构造方法：BitmapShader(Bitmap bitmap, Shader.TileMode tileX, Shader.TileMode tileY)
 * 参数：
 * bitmap：用来做模板的 Bitmap 对象
 * tileX：横向的 TileMode
 * tileY：纵向的 TileMode。
 * */
class Practice04BitmapShaderView: View{
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun draw(canvas: Canvas?) {
        super.draw(canvas)
        val paint = Paint()
        val bitmap = BitmapFactory.decodeResource(resources, R.drawable.dianyou_game_ic_my_dynamic)

        val shaderClamp = BitmapShader(bitmap,Shader.TileMode.CLAMP,Shader.TileMode.CLAMP)
        paint.shader = shaderClamp
        canvas!!.drawRect(100f,100f,400f,400f,paint)

        val shaderMirror = BitmapShader(bitmap,Shader.TileMode.MIRROR,Shader.TileMode.MIRROR)
        paint.shader = shaderMirror
        canvas.drawRect(100f,500f,400f,800f,paint)

        val shaderPepeat = BitmapShader(bitmap,Shader.TileMode.REPEAT,Shader.TileMode.REPEAT)
        paint.shader = shaderPepeat
        canvas.drawRect(500f,100f,800f,400f,paint)
    }
}