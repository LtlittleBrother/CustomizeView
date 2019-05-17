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
 * 使用Matrix.postSkew() 错切
 * 参数里的 sx 和 sy 是 x 方向和 y 方向的错切系数。
 * */
class Practice10MatrixSkew: View {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val paint = Paint()
        val matrix = Matrix()
        val matrix1 = Matrix()
        canvas!!.save()
        val bitmap = BitmapFactory.decodeResource(resources, R.drawable.dianyou_im_greedy_snake_icon)
        matrix.postSkew(0f,0.2f)
        canvas.concat(matrix)
        canvas.drawBitmap(bitmap,0f,bitmap.height.toFloat(),paint)
        canvas.restore()

        canvas.save()
        matrix1.postSkew(0.2f,0.2f,0f,0f)
        canvas.concat(matrix1)
        canvas.drawBitmap(bitmap,bitmap.width.toFloat(),0f,paint)
        canvas.restore()

        canvas.drawBitmap(bitmap,0f,0f,paint)
    }



}