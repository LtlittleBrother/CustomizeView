package com.customizeview

import android.animation.AnimatorSet
import android.animation.ArgbEvaluator
import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.support.v4.content.ContextCompat
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.view.animation.LinearInterpolator
import util.ViewUtil


class NumScrollView: View {

    private var paint = Paint()
    private lateinit var fontMetricd: Paint.FontMetrics
    private var currentNum = 999
    private var alterNum = 0
    private var textSize = ViewUtil.sp2px(context,15f).toFloat()
    private val ANIMATION_DURATION = 200L
    private var startX = 0f
    private var startY = 0f

    private var currentColor = ContextCompat.getColor(context,R.color.dialog_btn_gray_color)
    private var currentTranslate = 0f
    private var alterTranslate = 0f
    private var alterColor = ContextCompat.getColor(context,R.color.transparent)

    private var textHeight = 0

    private var textWidth = 0

    private lateinit var mTextBound: Rect

    private val MAX_NUM = "9999999"

    private val mTextSpacing = ViewUtil.dip2px(context,5f)


    private val textColor = ContextCompat.getColor(context,R.color.dialog_btn_gray_color)
    private val transparentColor = ContextCompat.getColor(context,R.color.transparent)

    private var isPraise = true

    private var totalHeight = 0

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    init {
        initPaint()
    }

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        drawCurrentText(canvas!!)
        drawAlterText(canvas)
    }

    fun initPaint(){
        paint = Paint()
        paint.isAntiAlias = true
        paint.textSize = textSize
        fontMetricd = paint.fontMetrics
        mTextBound = Rect()
        paint.getTextBounds(MAX_NUM,0,MAX_NUM.length,mTextBound)
        textHeight = mTextBound.height()
        textWidth = mTextBound.width()
        totalHeight = textHeight*3 + mTextSpacing*2
    }

    private fun drawCurrentText(canvas: Canvas?){
        canvas!!.save()
        paint.color = currentColor
        canvas.translate(0f,currentTranslate)
        canvas.drawText(currentNum.toString(),0f,(totalHeight/2)+textHeight.toFloat(),paint)
        canvas.restore()
        Log.d("liutao", "drawCurrentTextHeight == " + textHeight.toFloat()*2)
    }

    private fun drawAlterText(canvas: Canvas?){
        canvas!!.save()
        paint.color = alterColor
        canvas.translate(0f,alterTranslate)
        canvas.drawText(alterNum.toString(),0f,(totalHeight/2) + textHeight.toFloat()*2 + mTextSpacing,paint)
        canvas.restore()
        Log.d("liutao", "drawAlterTextTextHeight == " + textHeight.toFloat()*3)
    }

    fun upDataNum(isPraise: Boolean){
        this.isPraise = isPraise
        alterNum = if (isPraise){
            currentNum+1
        }else{
            currentNum-1
        }
        when {
            alterNum.toString().length > currentNum.toString().length -> {
                val currentNumAnima = ObjectAnimator.ofFloat(this,"currentTranslate",-(textHeight.toFloat()+mTextSpacing))
                currentNumAnima.interpolator = LinearInterpolator()
                currentNumAnima.duration = ANIMATION_DURATION
                val currentNumColor = ObjectAnimator.ofInt(this,"currentColor",textColor,transparentColor)
                currentNumColor.interpolator = LinearInterpolator()
                currentNumColor.setEvaluator(ArgbEvaluator())
                currentNumColor.duration = ANIMATION_DURATION

                val alterNum = ObjectAnimator.ofFloat(this,"alterTranslate",-(textHeight.toFloat()+mTextSpacing))
                alterNum.interpolator = LinearInterpolator()
                alterNum.duration = ANIMATION_DURATION
                val alterNumColor = ObjectAnimator.ofInt(this,"alterColor",transparentColor,textColor)
                alterNumColor.interpolator = LinearInterpolator()
                alterNumColor.setEvaluator(ArgbEvaluator())
                alterNumColor.duration = ANIMATION_DURATION

                val animatorSet = AnimatorSet()
                animatorSet.playTogether(currentNumAnima,currentNumColor,alterNum,alterNumColor)
                animatorSet.start()
            }
            alterNum.toString().length > currentNum.toString().length -> {

            }
            else -> {

            }
        }
    }

    fun setCurrentColor(color: Int){
        this.currentColor = color
        Log.d("liutao","currentColor == $currentColor")
        invalidate()
    }
    fun getCurrentColor(): Int{
        return 0
    }

    fun setCurrentTranslate(translate: Float){
        this.currentTranslate = translate
        Log.d("liutao","currentTranslate == $currentTranslate")
        invalidate()
    }

    fun getCurrentTranslate(): Float{
        return 0f
    }

    fun setAlterColor(color: Int){
        this.alterColor = color
        Log.d("liutao","alterColor == $alterColor")
        invalidate()
    }
    fun getAlterColor(): Int{
        return 0
    }

    fun setAlterTranslate(translate: Float){
        this.alterTranslate = translate
        Log.d("liutao","alterTranslate == $alterTranslate")
        invalidate()
    }

    fun getAlterTranslate(): Float{
        return 0f
    }




    private fun getTextRect(text: String, paint: Paint): Rect{
        val rect = Rect()
        paint.getTextBounds(text,startX.toInt(),startY.toInt(),rect)
        return rect
    }

    fun setCurrentNum(num: Int){
        this.currentNum = num
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        setMeasuredDimension(getViewWidth(widthMeasureSpec),getViewHeight(heightMeasureSpec))
        Log.d("liutao","onMeasure")
    }

    private fun getViewWidth(widthMeasureSpec: Int): Int{
        val specMode = MeasureSpec.getMode(widthMeasureSpec)
        val specSize = MeasureSpec.getSize(widthMeasureSpec)
        var width = textWidth
        when(specMode){
            MeasureSpec.AT_MOST -> {
                if (width > specSize){
                    width = specSize
                }
                return  width
            }
            MeasureSpec.UNSPECIFIED -> {
                return width
            }
            MeasureSpec.EXACTLY -> {
                return specSize
            }
        }
        return width
    }
    private fun getViewHeight(heightMeasureSpec: Int): Int{
        val specMode = MeasureSpec.getMode(heightMeasureSpec)
        val specSize = MeasureSpec.getSize(heightMeasureSpec)
        val height: Int = totalHeight
        Log.d("liutao","height == $height")
        when(specMode){
            MeasureSpec.AT_MOST -> {
                if (height > specSize){
                    return specSize
                }
                return height
            }
            MeasureSpec.UNSPECIFIED -> {
                return height
            }
            MeasureSpec.EXACTLY -> {
                return specSize
            }
        }
        return height
    }

}