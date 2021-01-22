package com.college.pmcd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.college.pmcd.adapter.ViewPagerAdapter
import com.college.pmcd.fragments.AboutFragment
import com.college.pmcd.fragments.HomeFragment
import com.google.android.material.tabs.TabLayout

class DashboardActivity : AppCompatActivity() {
    private lateinit var viewPager: ViewPager;
    private lateinit var tabLayout: TabLayout;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide();
        setContentView(R.layout.activity_dashboard);


        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);
        loadAdapter();

    }

    private fun loadAdapter() {
        val adapter = ViewPagerAdapter(supportFragmentManager);
        adapter.createFragments(HomeFragment(), "Home");
        adapter.createFragments(AboutFragment(), "About");

        viewPager.adapter = adapter;
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0)!!.setIcon(R.drawable.ic_home);
        tabLayout.getTabAt(1)!!.setIcon(R.drawable.ic_about);
    }
}