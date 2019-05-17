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
 * 使用Matrix.postRotate()旋转
 * */
class Practice09MatrixRotate: View {

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
        matrix.postRotate(45f,200f,bitmap.height.toFloat() + 200)
        canvas.concat(matrix)
        canvas.drawBitmap(bitmap,100f,bitmap.height.toFloat() +100,paint)
        canvas.restore()

        canvas.drawBitmap(bitmap,0f,0f,paint)
    }
}