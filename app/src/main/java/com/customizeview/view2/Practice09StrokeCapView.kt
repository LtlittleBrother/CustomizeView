package com.customizeview.view2

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

/***
 * BUTT 平头、ROUND 圆头、SQUARE 方头
 */
class Practice09StrokeCapView: View {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val paint = Paint()
        paint.isAntiAlias = true
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 50f
        paint.strokeCap = Paint.Cap.SQUARE //方头
        canvas!!.drawLine(100f,100f,600f,100f,paint)

        paint.strokeCap = Paint.Cap.ROUND //圆头
        canvas.drawLine(100f,300f,600f,300f,paint)

        paint.strokeCap = Paint.Cap.BUTT // 平头
        canvas.drawLine(100f,500f,600f,500f,paint)
    }
}