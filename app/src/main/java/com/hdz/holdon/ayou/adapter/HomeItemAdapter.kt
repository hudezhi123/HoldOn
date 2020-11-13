package com.hdz.holdon.ayou.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import butterknife.ButterKnife
import com.bumptech.glide.Glide
import com.hdz.holdon.R
import com.hdz.holdon.ayou.bean.StoryBean
import com.hdz.holdon.ayou.bean.StoryClassify

class HomeItemAdapter(context: Context?, dataList: List<StoryBean>?) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var context: Context?
    var dataList: List<StoryBean>
    lateinit var onClickListener: OnItemClickListener

    interface OnItemClickListener {
        fun onItemClickListener(position: Int, storyBean: StoryBean)
    }

    init {
        this.context = context;
        this.dataList = dataList ?: ArrayList<StoryBean>(0)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val rootView: View =
            LayoutInflater.from(context).inflate(R.layout.item_home_item_layout, parent, false)
        return HomeItemHolder(rootView)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is HomeItemHolder) {
            val storyItem = dataList.get(position)
            holder.textSkipCount.text = String.format("%s 浏览", storyItem.play_count)
            holder.textStepCount.text = String.format("%s步", storyItem.clip_num)
            holder.textTitle.text = storyItem.title
            Glide.with(context!!).load(storyItem.cover_url).into(holder.imgUrl)
        }
    }

    class HomeItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        @BindView(R.id.text_title_item_home)
        lateinit var textSkipCount: TextView
        @BindView(R.id.text_step_count_item_home)
        lateinit var textStepCount: TextView
        @BindView(R.id.text_title_item_home)
        lateinit var textTitle: TextView
        @BindView(R.id.img_cover_item_home)
        lateinit var imgUrl: ImageView

        init {
            ButterKnife.bind(this, itemView)
        }
    }
}