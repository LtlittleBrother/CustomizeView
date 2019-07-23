package com.customizeview.view7

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import com.customizeview.R


class PropertyValuesHolderView: View {

    private lateinit var bitmap: Bitmap

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val paint = Paint()
        bitmap = BitmapFactory.decodeResource(resources, R.drawable.music)
        paint.isAntiAlias = true
        paint.style = Paint.Style.FILL
        canvas!!.drawBitmap(bitmap,300f,200f,paint)
    }

    fun start(){
        this.animate()
                .scaleX(1f)
                .scaleY(1f)
                .start()
        invalidate()
    }

    fun objectAnimatorStart(){
        val holder1 = PropertyValuesHolder.ofFloat("scaleX", 2f)
        val holder2 = PropertyValuesHolder.ofFloat("scaleY", 2f)
        val holder3 = PropertyValuesHolder.ofFloat("alpha", 2f)

        val animator = ObjectAnimator.ofPropertyValuesHolder(this, holder1, holder2, holder3)
        animator.start()
    }

}