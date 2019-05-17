package com.customizeview.view4

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.customizeview.R

/**
 * Canvas.scale(float sx, float sy, float px, float py) 放缩
 *
 * 参数里的 sx sy 是横向和纵向的放缩倍数； px py 是放缩的轴心。
 * */
class Practice05Scale : View {

    private var sx = 0.5f
    private var sy = 0.5f

    private var px = 300f
    private var py = 200f


    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val paint = Paint()
        val bitmap = BitmapFactory.decodeResource(resources, R.drawable.dianyou_im_greedy_snake_icon)

        canvas!!.save()
        canvas.scale(sx, sy,px,py)
        canvas.drawBitmap(bitmap,300f,200f,paint)
        canvas.restore()

        paint.color = Color.RED
        paint.style = Paint.Style.FILL
        paint.strokeWidth = 20f
        canvas.drawPoint(px,py,paint)
        paint.textSize = 50f
        canvas.drawText("x$px\ny$py",px+20f,py,paint)
    }

    fun setSx(sx: Int){
        val sxNew = sx.toFloat()/100
        this.sx = sxNew
        invalidate()
    }

    fun setSy(sy: Int){
        val syNew = sy.toFloat()/100
        this.sy = syNew
        invalidate()
    }

    fun setPx(px: Int){
        this.px = px.toFloat()
        invalidate()
    }

    fun setPy(py: Int){
        this.py = py.toFloat()
        invalidate()
    }


}