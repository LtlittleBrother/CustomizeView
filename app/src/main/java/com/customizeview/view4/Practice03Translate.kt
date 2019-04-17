package com.customizeview.view4

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View
import com.customizeview.R

/**
 * Canvas.translate(float dx, float dy) 平移
 *参数里的 dx 和 dy 表示横向和纵向的位移。
 *
 * */
class Practice03Translate : View {


    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)


        val paint = Paint()
        val bitmap = BitmapFactory.decodeResource(resources, R.drawable.dianyou_im_greedy_snake_icon)
        canvas!!.save()
        canvas.translate((bitmap.width+50).toFloat(),0f)
        canvas.drawBitmap(bitmap,0f,0f,paint)
        canvas.restore()

        canvas.drawBitmap(bitmap,0f,0f,paint)
    }
}