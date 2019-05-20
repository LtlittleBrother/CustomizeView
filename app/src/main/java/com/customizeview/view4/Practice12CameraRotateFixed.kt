package com.customizeview.view4

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.customizeview.R
import com.customizeview.util.BitmapUtils

class Practice12CameraRotateFixed: View {

    private var degree: Int = 45
    private val mCamera = Camera()

    private var locationZ = 0

    private val point = Point(300,200)

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas) {
        val bitmap = BitmapUtils.getRawBitmap(resources, R.drawable.maps)
        val paint = Paint()

        // 画上半部分
        canvas.save()
        canvas.clipRect(point.x, point.y, point.x+bitmap.width / 2, point.y+bitmap.height)
        canvas.drawBitmap(bitmap, point.x.toFloat(), point.y.toFloat(), paint)
        canvas.restore()

        canvas.save()
        mCamera.save()
        mCamera.setLocation(0f,0f,locationZ.toFloat())
        canvas.translate((point.x+bitmap.width/2).toFloat(),point.y.toFloat())
        mCamera.rotateY(degree.toFloat())
        mCamera.applyToCanvas(canvas)
        mCamera.restore()
        canvas.translate(-(point.x+bitmap.width/2).toFloat(),-point.y.toFloat())
        canvas.clipRect(point.x+bitmap.width/2, point.y, point.x+bitmap.width, point.y+bitmap.height)
        canvas.drawBitmap(bitmap,point.x.toFloat(), point.y.toFloat(),paint)
        canvas.restore()

        paint.isAntiAlias = true

        bitmap.recycle()

    }

    fun setDegree(degree: Int) {
        val degreeNew = degree-360
        this.degree = degreeNew
        invalidate()
    }

    fun setLocationZ(locationZ: Int){
        this.locationZ = locationZ
        invalidate()
    }
}