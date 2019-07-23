package com.customizeview.view7

import android.animation.ArgbEvaluator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import android.animation.ObjectAnimator
import android.graphics.Color
import android.util.Log


class TypeEvaluatorView: View {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    //圆圈颜色
    private val START_COLOR = Color.parseColor("#00e24d3d")
    private val END_COLOR = Color.parseColor("#88e24d3d")

    private var color = START_COLOR

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val paint = Paint()
        paint.isAntiAlias = true
        paint.color = color
        paint.style = Paint.Style.FILL
        canvas!!.drawCircle(500f,300f,200f,paint)
    }

    fun setMyColor(color: Int){
        this.color = color
        Log.d("liutao", "color ==$color")
        invalidate()
    }

    fun getMyColor(){

    }

    fun start(){
        val animator = ObjectAnimator.ofInt(this, "myColor", START_COLOR, END_COLOR)
        animator.duration = 2000L
        animator.setEvaluator(ArgbEvaluator())
        animator.start()
    }

}