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
 * Canvas.scale(float sx, float sy, float px, float py) 放缩
 *
 * 参数里的 sx sy 是横向和纵向的放缩倍数； px py 是放缩的轴心。
 * */
class Practice05Scale : View {


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
        canvas.scale(0.5f, 0.5f,(bitmap.width+50+bitmap.width/2).toFloat(),(bitmap.height/2).toFloat())
        canvas.drawBitmap(bitmap,(bitmap.width+50).toFloat(),0f,paint)
        canvas.restore()

        canvas.save()
        canvas.scale(1.3f, 1.3f,(bitmap.width+50+bitmap.width/2).toFloat(),(bitmap.height/2).toFloat())
        canvas.drawBitmap(bitmap,100f,(bitmap.height+50).toFloat(),paint)
        canvas.restore()
    }
}