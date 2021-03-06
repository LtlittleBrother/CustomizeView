package com.customizeview.view4

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View
import com.customizeview.R

class Practice01ClipRect : View{

    private var clipX = 100
    private var clipY = 600

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val paint = Paint()
        val bitmap = BitmapFactory.decodeResource(resources, R.drawable.dianyou_im_greedy_snake_icon)
        canvas!!.drawBitmap(bitmap,100f,100f,paint)

        val rect = Rect(100,600,clipX,clipY)/**矩形的坐标*/
        canvas.save()
        canvas.clipRect(rect)
        canvas.drawBitmap(bitmap,100f,600f,paint)
        canvas.restore()
    }

    fun setClipX(clipX: Int){
        val x = clipX + 100
        this.clipX = x
        invalidate()
    }

    fun setClipY(clipY: Int){
        val y = clipY + 600
        this.clipY = y
        invalidate()
    }

}