package com.gaqiujun.moment1.module

import android.content.Intent
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.gaqiujun.moment1.R
import com.gaqiujun.moment1.module.hot.HotFrag
import com.gaqiujun.moment1.module.selected.SelectedFrag
import com.gaqiujun.moment1.module.sort.SortFrag
import com.gaqiujun.moment1.module.subject.SubjectFrag
import com.mingo.baselibrary.base.BaseSuperAct
import kotlinx.android.synthetic.main.frag_wallpaper.*

class MainActivity : BaseSuperAct() {
    private val fragments =
        arrayOf(SelectedFrag(), HotFrag(1), SubjectFrag(), SortFrag())
    private val titles = arrayOf("精选",  "最新", "专题", "分类")
    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initView() {
        setTransparentStatusBar()
    }

    override fun initData() {
        viewPager.adapter = WallpaperAdapter(supportFragmentManager)
        pagerSliding.setViewPager(viewPager)
    }

    override fun initEvent() {
    }

    private inner class WallpaperAdapter(fm: FragmentManager) :
        FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
        override fun getCount(): Int {
            return 4
        }

        override fun getItem(position: Int): Fragment {
            return fragments[position]
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return titles[position]
        }
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            val intent = Intent(Intent.ACTION_MAIN)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK// 注意
            intent.addCategory(Intent.CATEGORY_HOME)
            this.startActivity(intent)
            return true
        }
        return super.onKeyDown(keyCode, event)
    }

}