package com.example.kiiskin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import kotlinx.android.synthetic.main.activity_tab2.*


class TabActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab2)

        val adapter = MyViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(FragmentOne() , "PhotoLog ")
        adapter.addFragment(FragmentTwo() , "PhotoResult ")
        adapter.addFragment(FragmentThree() , "Support")
        adapter.addFragment(FragmentFour() , "UserProfiles")
        viewPager.adapter = adapter
        tab_layout.setupWithViewPager(viewPager)

    }


    class MyViewPagerAdapter(manager: FragmentManager) : FragmentPagerAdapter(manager){

        private val fragmentList : MutableList<Fragment> = ArrayList()
        private val titleList : MutableList<String> = ArrayList()

        override fun getItem(position: Int): Fragment {
            return fragmentList[position]
        }

        override fun getCount(): Int {
            return fragmentList.size
        }

        fun addFragment(fragment: Fragment,title:String){
            fragmentList.add(fragment)
            titleList.add(title)
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return titleList[position]
        }

    }

}