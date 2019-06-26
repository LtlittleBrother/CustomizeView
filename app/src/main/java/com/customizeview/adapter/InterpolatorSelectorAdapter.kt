package com.customizeview.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.customizeview.R

class InterpolatorSelectorAdapter: BaseQuickAdapter<String,BaseViewHolder>{

    constructor() : super(R.layout.interpolator_selector_dialog_item)

    override fun convert(helper: BaseViewHolder?, item: String?) {
        helper!!.setText(R.id.name_tv,item!!)
    }
}