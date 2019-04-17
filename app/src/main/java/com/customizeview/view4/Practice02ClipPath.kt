package com.customizeview.view4

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.customizeview.R

class Practice02ClipPath : View {


    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        val paint = Paint()
        val path = Path()
        val bitmap = BitmapFactory.decodeResource(resources, R.drawable.dianyou_im_greedy_snake_icon)
        canvas!!.drawBitmap(bitmap,0f,0f,paint)

        path.addCircle(bitmap.width/2.toFloat(), 800f, 200f, Path.Direction.CCW)
        canvas.save()
        canvas.clipPath(path)
        canvas.drawBitmap(bitmap,0f,600f, paint)
        canvas.restore()

        val path2 = Path()
        path2.addCircle(bitmap.width+(bitmap.width/2).toFloat(),300f,250f,Path.Direction.CW)
        canvas.save()
        canvas.clipPath(path2,Region.Op.XOR)/**多种样式可选择*/
        canvas.drawBitmap(bitmap,(bitmap.width+50).toFloat(),0f,paint)
        canvas.restore()

    }
}