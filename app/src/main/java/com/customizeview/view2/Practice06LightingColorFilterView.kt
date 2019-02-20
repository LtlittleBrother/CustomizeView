package com.customizeview.view2

import android.content.Context
import android.util.AttributeSet
import android.view.View

/**
 * 使用 Paint.setColorFilter() 来设置 LightingColorFilter
 * 第一个 LightingColorFilter：去掉红色部分
 * 第二个 LightingColorFilter：增强绿色部分
 * */
class Practice06LightingColorFilterView: View {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)
}