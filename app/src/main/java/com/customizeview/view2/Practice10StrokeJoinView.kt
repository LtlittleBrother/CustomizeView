package com.customizeview.view2

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View

/**
 * 设置拐角的形状。有三个值可以选择：
 * MITER 尖角、 BEVEL 平角和 ROUND 圆角。默认为 MITER。
 * */
class Practice10StrokeJoinView: View {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val paint = Paint()
        val path = Path()
        paint.strokeWidth = 50f
        paint.isAntiAlias = true
        path.moveTo(100f,100f)

        paint.strokeJoin = Paint.Join.ROUND // 圆头
        paint.style = Paint.Style.STROKE
        path.lineTo(700f,100f)
        path.lineTo(200f,400f)
        canvas!!.drawPath(path,paint)

        paint.strokeJoin = Paint.Join.BEVEL //平角
        val path1 = Path()
        path1.moveTo(100f,500f)
        path1.lineTo(700f,500f)
        path1.lineTo(200f,800f)
        canvas.drawPath(path1,paint)

        paint.strokeJoin = Paint.Join.MITER //尖角
        val path2 = Path()
        path2.moveTo(100f,900f)
        path2.lineTo(700f,900f)
        path2.lineTo(200f,1200f)
        canvas.drawPath(path2,paint)
    }
}