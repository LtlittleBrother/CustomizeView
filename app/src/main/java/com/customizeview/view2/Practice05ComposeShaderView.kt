package com.customizeview.view2

import android.content.Context
import android.util.AttributeSet
import android.view.View

/**
 *  用 Paint.setShader(shader) 设置一个 ComposeShader
 *  Shader 1: BitmapShader 图片：R.drawable.batman
 *  Shader 2: BitmapShader 图片：R.drawable.batman_logo
 * */
class Practice05ComposeShaderView: View{
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)
}