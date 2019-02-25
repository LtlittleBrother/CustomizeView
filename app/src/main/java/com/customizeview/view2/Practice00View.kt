package com.customizeview.view2

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class Practice00View: View{

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val paint = Paint()
        paint.color = Color.parseColor("#009688")
        canvas!!.drawRect(50f,50f,200f,200f,paint)

        paint.color = Color.parseColor("#FF9800")
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = 20f
        canvas.drawLine(400f,50f,230f,200f,paint)

        paint.style = Paint.Style.FILL
        paint.textSize = 36f
        paint.color = Color.parseColor("#E91E63")
        canvas.drawText("HelloWorld",600f,100f,paint)
    }
}
