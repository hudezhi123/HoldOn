package com.hdz.holdon.ayou.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import butterknife.ButterKnife
import butterknife.Unbinder
import com.hdz.holdon.R
import com.hdz.holdon.ayou.adapter.HomeAdapter
import com.hdz.holdon.ayou.bean.StoryBean
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    lateinit var mAdapter: HomeAdapter
    var mUnBind: Unbinder? = null;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView: View = inflater.inflate(R.layout.fragment_home, container, false)
        mUnBind = ButterKnife.bind(this, rootView)
        return rootView
    }

    fun init() {
        val manager = LinearLayoutManager(activity)
        mAdapter = HomeAdapter(context)
        recyclerview_home.layoutManager = manager
        recyclerview_home.adapter = mAdapter
        mAdapter.onChildItemListener = object : HomeAdapter.OnChildItemClickListener {
            override fun onChildClick(childPosition: Int, position: Int, storyBean: StoryBean) {
                Toast.makeText(
                    context,
                    "childPosition=$childPosition,parentPosition=$position",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        swipe_refresh_home.setOnRefreshListener(object : SwipeRefreshLayout.OnRefreshListener {
            override fun onRefresh() {

            }
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    override fun onResume() {
        super.onResume()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        mUnBind?.unbind()
    }
}
