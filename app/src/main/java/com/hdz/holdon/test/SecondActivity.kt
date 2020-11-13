package com.hdz.holdon.test

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hdz.holdon.R
import com.hdz.holdon.test.Adapter.OnItemClickListener


class SecondActivity : AppCompatActivity() {

    var mListView: RecyclerView? = null
    var mManager: LinearLayoutManager? = null
    var mAdapter: Adapter? = null
    var dataList: MutableList<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        init()
    }

    private fun init() {
        dataList = ArrayList<String>()
        for (index in 0 until 20) {
            dataList!!.add("第${index + 1}条数据")
        }
        mManager = LinearLayoutManager(this)
        initView()
    }

    private fun initView() {
        mListView = findViewById(R.id.recycler_view_second)
        mAdapter = Adapter(this, dataList)
        mListView!!.layoutManager = mManager;
        mListView!!.adapter = mAdapter
        mAdapter!!.onItemClickListener = object : OnItemClickListener {
            override fun onItemClick(position: Int) {
                Toast.makeText(this@SecondActivity, "点击了第${position + 1}调数据", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
}
