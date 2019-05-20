package com.customizeview.view4

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.support.v4.content.ContextCompat
import android.util.AttributeSet
import android.view.View
import com.customizeview.R
import kotlinx.android.synthetic.main.customize_view_two_fragment_layout.view.*
import java.text.DecimalFormat


class Practice13CameraRotateHittingFace: View {

    private val point = Point(300,300)
    private var endAngle = 108f
    private var current = "30%"
    private var circleRadius = 200
    private var startAngle = 180f

    private var df = DecimalFormat("0.00")
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        val paintCircle = Paint()
        paintCircle.isAntiAlias = true
        paintCircle.style = Paint.Style.STROKE
        paintCircle.strokeWidth = 22f
        paintCircle.isAntiAlias = true
        paintCircle.color = Color.parseColor("#999999")
        canvas!!.drawCircle(point.x.toFloat(),point.y.toFloat(),circleRadius.toFloat(),paintCircle)
//        canvas.drawCircle(point.x.toFloat(),point.y.toFloat(),circleRadius-10.toFloat(),paintCircle)

        val paintCircleProgress = Paint()
        paintCircleProgress.style = Paint.Style.STROKE
        paintCircleProgress.isAntiAlias = true
        paintCircleProgress.strokeWidth = 20f
        paintCircleProgress.color = Color.RED
        canvas.drawArc(point.x.toFloat()-circleRadius,point.y.toFloat()-circleRadius,point.x.toFloat()+circleRadius,point.y.toFloat()+circleRadius,startAngle,endAngle,false,paintCircleProgress)

        val paintText = Paint()
        paintText.style = Paint.Style.STROKE
        paintText.textSize = 60f
        paintText.isAntiAlias = true
        paintText.color = Color.RED
        val text = current
        val rect= Rect()
        paintText.getTextBounds(text,0,text.length,rect)
        canvas.drawText(text,point.x.toFloat() - rect.width()/2,point.y.toFloat()+rect.height()/2,paintText)
    }

    fun setStartAngle(currentAngle: Int){
        val currentAlgleNew = currentAngle.toDouble()/100
            this.endAngle = (currentAlgleNew * 3.6).toFloat()
        this.current = df.format(currentAlgleNew)+ "%"
        invalidate()
    }

}