package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main3.*
import kotlinx.android.synthetic.main.fragment_add_item.*
import kotlinx.android.synthetic.main.fragment_items.*


class MainActivity3 : AppCompatActivity() {
    private lateinit var viewpager2 : ViewPager2
    private lateinit var viewPagerAdapter : ViewPagerAdapter
    private lateinit var tabLayout: TabLayout




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        viewpager2 = findViewById(R.id.viewPager2)
        tabLayout = findViewById(R.id.tabLayout)
        viewPagerAdapter = ViewPagerAdapter(this)
        viewpager2.adapter = viewPagerAdapter
        TabLayoutMediator(tabLayout,viewPager2){tab , position ->
            when(position){
                0->{
                    tab.text = "Add Item"
                }
                1->{
                    tab.text = "Profile"
                }
            }




    }.attach()
}
}