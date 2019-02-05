package com.justcodenow.introscreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var introArrayList = ArrayList<IntroModel>()
    private var mIntroScreenAdapter: IntroScreenAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        createArrayList()
        initRecyclerView()
    }

    private fun initRecyclerView() {
        rv_intro.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        mIntroScreenAdapter = IntroScreenAdapter(this, introArrayList)
        val snapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(rv_intro)
        rv_intro.addItemDecoration(CirclePagerIndicatorDecoration())
        rv_intro.adapter = mIntroScreenAdapter
    }

    /***
     * demo mArrayList
     */
    private fun createArrayList() {
        introArrayList.clear()
        for ((i, _) in Constants().mImages.withIndex()) {
            introArrayList.add(IntroModel(i.toString(), Constants().mImages[i]))
        }
    }
}
