package com.customizeview.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.customizeview.fragment.CustomizeViewSixFragment
import java.util.ArrayList

class CustomizeViewSixFgAdapter : FragmentStatePagerAdapter{

    private var mTitles : ArrayList<String> = ArrayList()
    private var mFragments : ArrayList<CustomizeViewSixFragment> = ArrayList()

    constructor(fm: FragmentManager?) : super(fm)

    override fun getItem(position: Int): Fragment {
        return mFragments[position]
    }

    override fun getCount(): Int {
        return mTitles.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return if (mTitles.isEmpty()) "" else mTitles[position]
    }

    fun destory(){
        if (mFragments.isNotEmpty()){
            for (fragment: CustomizeViewSixFragment in mFragments){
                fragment.onDestroy()
            }
        }
    }

    fun clear(){
        if (mTitles.isNotEmpty() && mFragments.isNotEmpty()){
            mTitles.clear()
            mFragments.clear()
        }
    }

    fun add(item : String){
        mTitles.add(item)

        mFragments.add(CustomizeViewSixFragment().newInstance(item))
    }

    fun remove(position : Int){
        mTitles.removeAt(position)
        mFragments.removeAt(position)
    }

}