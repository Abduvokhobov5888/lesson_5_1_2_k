package com.example.a512k

import android.content.Intent
import android.os.Bundle
import android.text.Html
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper

class MainActivity : AppCompatActivity() {
    private lateinit var rv: RecyclerView
    private lateinit var dotsLayout: LinearLayout
    lateinit var btn: Button
    private lateinit var dots: Array<TextView?>
    lateinit var animation: Animation
    lateinit var textView: TextView
    private lateinit var item: ArrayList<ItemModel>
    lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getData()
        setRv()

        textView = findViewById(R.id.textSkip)
        dotsLayout = findViewById(R.id.dots)

        textView.setOnClickListener(View.OnClickListener { rv.smoothScrollToPosition(2) })

        btn = findViewById(R.id.button)
        btn.setOnClickListener(View.OnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        })
        addDots(0)
    }

    private fun setRv() {

        rv = findViewById(R.id.rv)
        linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rv.layoutManager = linearLayoutManager

        val snapHelper: SnapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(rv)


        rv.addOnScrollListener(object : RecyclerView.OnScrollListener() {

            override fun onScrollStateChanged(recyclerView: RecyclerView, position: Int) {
                var position = 0
                position = linearLayoutManager.findFirstVisibleItemPosition()

                if (position == 0) {
                    btn?.visibility = View.INVISIBLE
                    textView?.visibility = View.VISIBLE
                } else if (position == 1) {
                    btn?.visibility = View.INVISIBLE
                    textView?.visibility = View.VISIBLE
                } else {
                    btn?.visibility = View.VISIBLE
                    textView?.visibility = View.INVISIBLE
                }


            }


            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {}
        })
        val recyclerAdapter = RecyclerAdapter(this, item)
        rv.setAdapter(recyclerAdapter)
        btn = findViewById(R.id.button)
        btn.setOnClickListener(View.OnClickListener {
            startActivity(
                Intent(
                    this,
                    MainActivity::class.java
                )
            )
        })
    }



    private fun getData() {
        item = ArrayList()
        item.add(ItemModel(R.raw.fraglottie, "Say Hello to \n Global Top-Up", "Send mobile top-up to more than 500 networks in over 140 countries."))
        item.add(ItemModel(R.raw.secondfraglottie, "Safe, Trusted & \n Fully Secure", "Encrypted transactions mean your payments & Privacy and protected."))
        item.add(ItemModel(R.raw.thirdfraglottie, "Easy to Use", "Pick a number, choose an amount, send your Top-up. Simple."))
    }

    private fun addDots(position: Int) {
        dots = arrayOfNulls(3)
        dotsLayout.removeAllViews()
        for (i in dots.indices) {
            dots[i] = TextView(this)
            dots[i]!!.text = Html.fromHtml("&#8226;")
            dots[i]!!.textSize = 35f
            dotsLayout.addView(dots[i])
        }
        if (dots.isNotEmpty()) {
            dots[position]!!.setTextColor(resources.getColor(R.color.blue))
        }
    }
}