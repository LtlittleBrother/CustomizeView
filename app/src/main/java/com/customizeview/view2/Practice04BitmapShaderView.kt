package com.customizeview.view2

import android.content.Context
import android.util.AttributeSet
import android.view.View

/**
 * 用 Paint.setShader(shader) 设置一个 BitmapShader
 * Bitmap: R.drawable.batman
 * */
class Practice04BitmapShaderView: View{
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)
}