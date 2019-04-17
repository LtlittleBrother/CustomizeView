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
        canvas.skew(0.1f,0f)/***/
        canvas.drawBitmap(bitmap,(bitmap.width+50).toFloat(),0f,paint)
        canvas.restore()

        canvas.save()
        canvas.skew(-0.1f,0f)/***/
        canvas.drawBitmap(bitmap,300f,(bitmap.height+50).toFloat(),paint)
        canvas.restore()
    }
}