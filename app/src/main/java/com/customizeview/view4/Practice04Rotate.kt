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
 * Canvas.rotate(float degrees, float px, float py) 旋转
 * 参数里的 degrees 是旋转角度，单位是度（也就是一周有 360° 的那个单位），方向是顺时针为正向； px 和 py 是轴心的位置（也就是坐标点）。
 *
 * */
class Practice04Rotate : View {


    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val paint = Paint()
        val bitmap = BitmapFactory.decodeResource(resources, R.drawable.dianyou_im_greedy_snake_icon)
        canvas!!.drawBitmap(bitmap,0f,0f,paint)

        canvas.save()
        canvas.rotate(45f,(bitmap.width+50+bitmap.width/2).toFloat(),(bitmap.height/2).toFloat())
        canvas.drawBitmap(bitmap,(bitmap.width+50).toFloat(),0f,paint)
        canvas.restore()


    }
}