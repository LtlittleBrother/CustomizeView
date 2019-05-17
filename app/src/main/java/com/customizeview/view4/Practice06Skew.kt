package com.customizeview.view4

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.customizeview.R
/**
 * skew(float sx, float sy) 错切
 * 参数里的 sx 和 sy 是 x 方向和 y 方向的错切系数。
 *
 * */
class Practice06Skew : View {

    private var sx = 0f
    private var sy = 0f

    private var direction = 2

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val paint = Paint()
        val bitmap = BitmapFactory.decodeResource(resources, R.drawable.dianyou_im_greedy_snake_icon)
        canvas!!.save()
        canvas.skew(sx,sy)/***/
        canvas.drawBitmap(bitmap,300f,200f,paint)
        canvas.restore()
    }

    fun setSkewX(sx: Int){
        val sxNew = sx.toFloat()/100
        if (direction == 2){
            this.sx = sxNew
        }else{
            this.sx = -sxNew
        }
        invalidate()
    }

    fun setSkewY(sy: Int){
        val syNew = sy.toFloat()/100
        if (direction == 2){
            this.sy = syNew
        }else{
            this.sy = -syNew
        }
        invalidate()
    }


    fun setDirection(direction: Int){
        this.direction = direction
        invalidate()
    }
}