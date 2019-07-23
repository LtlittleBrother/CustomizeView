package com.customizeview

import android.animation.Animator
import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.animation.AnimatorSet
import android.animation.ArgbEvaluator
import android.view.animation.LinearInterpolator
import util.ViewUtil


class PraiseView: View,View.OnClickListener {

    private var praiseSelected = BitmapFactory.decodeResource(resources, R.drawable.ic_messages_like_selected)
    private var praiseNoSelected = BitmapFactory.decodeResource(resources,R.drawable.ic_messages_like_unselected)
    private var praiseSelectedShining = BitmapFactory.decodeResource(resources, R.drawable.ic_messages_like_selected_shining)
    private lateinit var paint: Paint

    private val ANIMATION_DURATION = 200L

    private val PRAISE_SELECTED_SHINING_SCALE_MIN = 0f
    private val PRAISE_SCALE_MIN = 0.9f
    private val PRAISE_CIRCLE_MAX = 1f
    private val PRAISE_CIRCLE_MIN = 0.5f
    private val PRAISE_SCALE_MAX = 1f

    private var padding = ViewUtil.dip2px(context,5f).toFloat()

    /**圆圈线条的宽度*/
    private var strokeWidth = ViewUtil.dip2px(context,1f).toFloat()

    /**praiseSelected绘制时想上移动的部分*/
    private var marginTop = ViewUtil.dip2px(context,7f).toFloat()
    /**praiseSelectedShining绘制是向右移动的距离*/
    private var marginRight = ViewUtil.dip2px(context,2f).toFloat()

    /**总的bitmap的高度*/
    private var bitmapHeight = praiseSelectedShining.height + praiseSelected.height - marginTop
    /**总的bitmap的宽度*/
    private var bitmapWidth = praiseSelected.width

    /**总高度*/
    private var squareHeight = padding*2 + bitmapHeight + strokeWidth*2
    /**总宽度*/
    private var squareWidth = padding*2 + bitmapWidth + strokeWidth*2


    private var startX = padding + strokeWidth
    private var startY = padding + strokeWidth


    //圆圈颜色
    private val START_COLOR = Color.parseColor("#00e24d3d")
    private val END_COLOR = Color.parseColor("#88e24d3d")

    private var bitmpShiningScale = 0f
    private var bitmpSelectedScale = 1f

    private var circleScale = 0f
    private var circleColor = START_COLOR

    private var isPraise = false


    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        paint = Paint()
        paint.isAntiAlias = true
        if (isPraise){
            drawPraiseSelectedShining(canvas)
            drawPraiseSelected(canvas)
            drawCircle(canvas)
        }else{
            drawPraiseNoselected(canvas)
        }
        setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        Log.d("liutao","点赞")
        isPraise = if (isPraise){
            showPraiseNoselected()
            false
        }else{
            showPraiseSelected()
            true
        }

    }

    private fun drawPraiseNoselected(canvas: Canvas?){
        canvas!!.save()
        canvas.scale(bitmpSelectedScale,bitmpSelectedScale,startX + praiseSelectedShining.width/2.toFloat(),startY + praiseSelectedShining.height.toFloat())
        canvas.drawBitmap(praiseNoSelected,startX,(startY + praiseSelectedShining.height-marginTop),paint)
        canvas.restore()
    }

    private fun drawPraiseSelectedShining(canvas: Canvas?){
        canvas!!.save()
        canvas.scale(bitmpShiningScale,bitmpShiningScale,startX + praiseSelectedShining.width/2.toFloat(),startY + praiseSelectedShining.height.toFloat())
        canvas.drawBitmap(praiseSelectedShining,(startX + marginRight),startY,paint)
        canvas.restore()
    }

    private fun drawPraiseSelected(canvas: Canvas?){
        canvas!!.save()
        canvas.scale(bitmpSelectedScale,bitmpSelectedScale,startX + praiseSelected.width/2.toFloat(),startY + praiseSelected.height/2.toFloat())
        canvas.drawBitmap(praiseSelected,startX,(startY + praiseSelectedShining.height-marginTop),paint)
        canvas.restore()
    }

    private fun drawCircle(canvas: Canvas?){
        paint.style = Paint.Style.STROKE
        paint.color = circleColor
        paint.strokeWidth = strokeWidth
        canvas!!.save()
        canvas.scale(circleScale,circleScale,startX + praiseSelected.width/2.toFloat(),startY + praiseSelected.height/2.toFloat())
        canvas.drawCircle(squareWidth/2,squareHeight/2.toFloat(),squareHeight/2 - strokeWidth,paint)
        canvas.restore()
    }

    fun setBitmpShiningScale(scale: Float){
        this.bitmpShiningScale = scale
        Log.d("liutao", "bitmpShiningScale == $bitmpShiningScale")
        invalidate()
    }
    fun getBitmpShiningScale(): Float{
        return PRAISE_SELECTED_SHINING_SCALE_MIN
    }

    fun setBitmpSelectedScale(scale: Float){
        this.bitmpSelectedScale = scale
        Log.d("liutao", "bitmpSelectedScale == $bitmpSelectedScale")
        invalidate()
    }
    fun getBitmpSelectedScale(): Float{
        return PRAISE_SCALE_MIN
    }

    fun setBitmpNoSelectedScale(scale: Float){
        this.bitmpSelectedScale = scale
        invalidate()
    }
    fun getBitmpNoSelectedScale(): Float{
        return PRAISE_SCALE_MIN
    }

    fun setCircleAnimatorScale(scale: Float){
        this.circleScale = scale
        invalidate()
    }
    fun getCircleAnimatorScale(): Float{
        return PRAISE_CIRCLE_MIN
    }

    fun setCircleColor(color: Int){
        this.circleColor = color
        invalidate()
    }

    fun getCircleColor(): Int{
        return START_COLOR
    }

    fun showPraiseSelected(){

        val bitmpShining = ObjectAnimator.ofFloat(this,"bitmpShiningScale",PRAISE_SELECTED_SHINING_SCALE_MIN,PRAISE_SCALE_MAX)
        bitmpShining.interpolator = LinearInterpolator()
        bitmpShining.duration = ANIMATION_DURATION

        val bitmpSelected = ObjectAnimator.ofFloat(this,"bitmpSelectedScale",PRAISE_SCALE_MIN,PRAISE_SCALE_MAX)
        bitmpSelected.interpolator = LinearInterpolator()
        bitmpSelected.duration = ANIMATION_DURATION

        val circleScaleAnimator = ObjectAnimator.ofFloat(this,"circleAnimatorScale",PRAISE_SELECTED_SHINING_SCALE_MIN,PRAISE_CIRCLE_MAX)
        circleScaleAnimator.interpolator = LinearInterpolator()
        circleScaleAnimator.duration = ANIMATION_DURATION

        val circleGradientAnimator= ObjectAnimator.ofInt(this,"circleColor",START_COLOR, END_COLOR,0)
        circleGradientAnimator.interpolator = LinearInterpolator()
        circleGradientAnimator.setEvaluator(ArgbEvaluator())
        circleGradientAnimator.duration = ANIMATION_DURATION

        val animatorSet = AnimatorSet()
        /**四个动画同时执行*/
        animatorSet.playTogether(bitmpShining,bitmpSelected,circleScaleAnimator,circleGradientAnimator)
        animatorSet.start()
        animatorSet.addListener(object :Animator.AnimatorListener{
            override fun onAnimationRepeat(animation: Animator?) {
                /**当动画通过 setRepeatMode() / setRepeatCount() 或 repeat() 方法重复执行时，这个方法被调用。**/
            }

            override fun onAnimationEnd(animation: Animator?) {
                /**当动画结束时，这个方法被调用。*/
            }

            override fun onAnimationCancel(animation: Animator?) {
                /**当动画被通过 cancel() 方法取消时，这个方法被调用。*/
            }

            override fun onAnimationStart(animation: Animator?) {
                /**当动画开始执行时，这个方法被调用。*/
            }
        })

    }

    fun showPraiseNoselected(){
        val bitmpNoSelected = ObjectAnimator.ofFloat(this,"bitmpNoSelectedScale",PRAISE_SCALE_MIN,PRAISE_SCALE_MAX)
        bitmpNoSelected.duration = ANIMATION_DURATION
        bitmpNoSelected.start()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        setMeasuredDimension(getViewWidth(widthMeasureSpec),getViewHeight(heightMeasureSpec))
    }

    private fun getViewWidth(widthMeasureSpec: Int): Int{
        val specMode = MeasureSpec.getMode(widthMeasureSpec)
        val specSize = MeasureSpec.getSize(widthMeasureSpec)
        var width = squareHeight.toInt()
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
        val height: Int = squareHeight.toInt()
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