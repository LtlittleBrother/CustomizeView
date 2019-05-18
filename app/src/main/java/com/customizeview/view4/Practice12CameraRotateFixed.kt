package com.customizeview.view4

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.customizeview.R
import com.customizeview.util.BitmapUtils

class Practice12CameraRotateFixed: View {

    private var degree: Int = 45
    private val mCamera = Camera()

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onDraw(canvas: Canvas) {
        val bitmap = BitmapUtils.getRawBitmap(resources, R.drawable.maps)

        // 画上半部分
        canvas.save()
        canvas.translate((measuredWidth / 2).toFloat(), (measuredHeight / 2).toFloat())
        canvas.clipRect(-bitmap.width / 2, -bitmap.height / 2, bitmap.width / 2, 0)
        canvas.drawBitmap(bitmap, (-bitmap.width / 2).toFloat(), (-bitmap.height / 2).toFloat(), null)
        canvas.restore()

        canvas.save()
        canvas.translate((measuredWidth / 2).toFloat(), (measuredHeight / 2).toFloat())
        mCamera.save()
        mCamera.rotateX(degree.toFloat())
        mCamera.applyToCanvas(canvas)
        mCamera.restore()
        canvas.clipRect(-bitmap.width / 2, 0, bitmap.width / 2, bitmap.height / 2)
        canvas.drawBitmap(bitmap, (-bitmap.width / 2).toFloat(), (-bitmap.height / 2).toFloat(), null)
        canvas.restore()
        bitmap.recycle()
    }

    fun setDegree(degree: Int) {
        val degreeNew = degree-360
        this.degree = degreeNew
        invalidate()
    }
}