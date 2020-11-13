package com.hdz.holdon.ayou.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import com.hdz.holdon.R
import com.hdz.holdon.ayou.bean.StoryBean
import com.hdz.holdon.ayou.bean.StoryClassify

class HomeAdapter(context: Context?) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var context: Context?
    var mList: ArrayList<StoryClassify>
    lateinit var onChildItemListener: OnChildItemClickListener

    interface OnChildItemClickListener {
        fun onChildClick(childPosition: Int, position: Int, storyBean: StoryBean);
    }

    init {
        this.context = context;
        this.mList = ArrayList()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val rootView: View =
            LayoutInflater.from(context).inflate(R.layout.item_home_layout, parent, false)
        return HomeHolder(rootView)
    }

    override fun getItemCount(): Int = mList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is HomeHolder) {
            val storyClassify: StoryClassify = mList.get(position);
            holder.textTitle.text = storyClassify.title
            holder.textSubTitle.text = storyClassify.subtitle
            holder.mListView.layoutManager = LinearLayoutManager(context)
            val adapter: HomeItemAdapter = HomeItemAdapter(context, storyClassify.story_list)
            holder.mListView.adapter = adapter
            adapter.onClickListener = object : HomeItemAdapter.OnItemClickListener {
                override fun onItemClickListener(position: Int, storyBean: StoryBean) {

                }
            }

        }
    }


    class HomeHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        @BindView(R.id.text_title_home_item)
        lateinit var textTitle: TextView
        @BindView(R.id.text_subtitle_home_item)
        lateinit var textSubTitle: TextView
        @BindView(R.id.recyclerview_content_home_item)
        lateinit var mListView: RecyclerView

        init {
            ButterKnife.bind(this, itemView)
        }
    }
}