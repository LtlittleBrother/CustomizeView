package com.customizeview.view2

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class Practice15FillPathView: View {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)


    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val paint = Paint()
        val path = Path()
        val dashPath = Path()
        paint.isAntiAlias = true
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 20f
        dashPath.addCircle(30f,10f,40f,Path.Direction.CW)
        val pathEffect = PathDashPathEffect(dashPath,40f, 0f, PathDashPathEffect.Style.TRANSLATE)
        paint.pathEffect = pathEffect
        paint.color = Color.parseColor("#ff5548")
        path.moveTo(100f,100f)
        path.lineTo(300f,500f)
        path.lineTo(500f,150f)
        path.lineTo(700f,600f)
        path.lineTo(900f,50f)
        path.lineTo(1100f,550f)

        /**「实际 Path」。所谓实际 Path ，指的就是 drawPath() 的绘制内容的轮廓，要算上线条宽度和设置的 PathEffect。
         * 默认情况下（线条宽度为 0、没有 PathEffect），原 Path 和实际 Path 是一样的；
         * 而在线条宽度不为 0 （并且模式为 STROKE 模式或 FLL_AND_STROKE ），或者设置了 PathEffect 的时候，实际 Path 就和原  Path 不一样了：*/
//        paint.getFillPath(dashPath,path)
        canvas!!.drawPath(path, paint)
    }
}