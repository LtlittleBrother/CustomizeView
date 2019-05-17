package com.customizeview.view4

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Matrix
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.customizeview.R

/**
 * 使用Matrix.postTranslate()平移
 * */

class Practice07MatrixTranslate: View {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val paint = Paint()
        val matrix = Matrix()
        canvas!!.save()
        val bitmap = BitmapFactory.decodeResource(resources, R.drawable.dianyou_im_greedy_snake_icon)
        matrix.postTranslate((bitmap.width/2).toFloat(),bitmap.height.toFloat() +100)
        canvas.matrix = matrix
        canvas.drawBitmap(bitmap,0f,0f,paint)
        canvas.restore()

        canvas.drawBitmap(bitmap,0f,0f,paint)

    }
}