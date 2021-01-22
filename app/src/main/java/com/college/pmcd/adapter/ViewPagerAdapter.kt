package com.college.pmcd.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class ViewPagerAdapter(
    supportFragmentManager: FragmentManager
) : FragmentPagerAdapter(supportFragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val listOfFragment: ArrayList<Fragment> = ArrayList<Fragment>();
    private val listOfFragmentTitle: ArrayList<String> = ArrayList<String>();

    override fun getItem(position: Int): Fragment {
        return listOfFragment[position];
    }

    override fun getCount(): Int {
        return listOfFragment.size;
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return listOfFragmentTitle[position];
    }

    fun createFragments(fragment: Fragment, title: String) {
        listOfFragment.add(fragment);
        listOfFragmentTitle.add(title);
        notifyDataSetChanged();
    }

}