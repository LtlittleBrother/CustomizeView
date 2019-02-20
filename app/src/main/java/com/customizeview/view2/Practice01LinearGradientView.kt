package com.customizeview.view2

import android.content.Context
import android.util.AttributeSet
import android.view.View

/**用 Paint.setShader(shader) 设置一个 LinearGradient
 * LinearGradient 的参数：坐标：(100, 100) 到 (500, 500) ；颜色：#E91E63 到 #2196F3*/
class Practice01LinearGradientView: View{
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)
}