package com.customizeview.view4

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.customizeview.R

class Practice02ClipPath : View {

    private var regionType = 0

    private var circleX = 300f
    private var circleY = 200f

    private var radius = 100f

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        val paint = Paint()
        val path = Path()
        val bitmap = BitmapFactory.decodeResource(resources, R.drawable.dianyou_im_greedy_snake_icon)

        path.addCircle(circleX,circleY,radius,Path.Direction.CW)
        canvas!!.save()
        when(regionType){
            1 -> {
                canvas.clipPath(path,Region.Op.INTERSECT)/**多种样式可选择*/
            }
            2 -> {
                canvas.clipPath(path,Region.Op.UNION)/**多种样式可选择*/
            }
            3 -> {
                canvas.clipPath(path,Region.Op.XOR)/**多种样式可选择*/
            }
            4 -> {
                canvas.clipPath(path,Region.Op.REVERSE_DIFFERENCE)/**多种样式可选择*/
            }
            5 -> {
                canvas.clipPath(path,Region.Op.REPLACE)/**多种样式可选择*/
            }
        }
        canvas.drawBitmap(bitmap,300f,100f,paint)
        canvas.restore()

    }

    fun setRegionType(regionType: Int){
        this.regionType = regionType
        invalidate()
    }

    fun setCircleX(circleX: Int){
        this.circleX = circleX.toFloat()
        invalidate()
    }
    fun setCircleY(circleY: Int){
        this.circleY = circleY.toFloat()
        invalidate()
    }
    fun setRadius(radius: Int){
        val radiusNew = radius + 100f
        this.radius = radiusNew
        invalidate()
    }

}