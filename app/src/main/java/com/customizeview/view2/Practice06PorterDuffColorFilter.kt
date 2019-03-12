package com.customizeview.view2

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.customizeview.R

class Practice06PorterDuffColorFilter : View{

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val paint = Paint()
        val bitmap = BitmapFactory.decodeResource(resources, R.drawable.dianyou_red)
        val porterDuffColorFilter = PorterDuffColorFilter(Color.RED, PorterDuff.Mode.DST_OUT)
        paint.colorFilter = porterDuffColorFilter
        canvas!!.drawBitmap(bitmap,0f,0f,paint)
    }
}