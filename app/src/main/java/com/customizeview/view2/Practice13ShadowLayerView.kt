package com.customizeview.view2

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

/**
 * setShadowLayer(float radius, float dx, float dy, int shadowColor)
 * 在之后的绘制内容下面加一层阴影。
 *
 * 注意：
 * 如果要清除阴影层，使用 clearShadowLayer() 。
 * 在硬件加速开启的情况下， setShadowLayer() 只支持文字的绘制，文字之外的绘制必须关闭硬件加速才能正常绘制阴影。
 * 如果 shadowColor 是半透明的，阴影的透明度就使用 shadowColor 自己的透明度；而如果  shadowColor 是不透明的，阴影的透明度就使用 paint 的透明度。
 * */
class Practice13ShadowLayerView: View {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val paint = Paint()
        paint.textSize = 100f
        paint.color = Color.RED
        paint.setShadowLayer(10f,0f,0f,Color.BLUE)
        canvas!!.drawText("setShadowLayer",100f,100f,paint)
    }
}