package com.hdz.holdon.ayou.bean

import android.annotation.SuppressLint
import android.os.Parcel
import android.os.Parcelable

@SuppressLint("ParcelCreator")
class StoryBean @SuppressLint("ParcelCreator") constructor(parcel: Parcel) : Parcelable {

    var story_id: String? = null
    var title: String? = null
    var cover_url: String? = null
    var clip_num = 0
    var play_count = 0
    var like_count = 0
    var status: String? = null

    var user_id: String? = null
    var nickname: String? = null
    var head_url: String? = null
    var is_collect = false
    var is_subscribe = false
    var is_rate = false

    init {
        story_id = parcel.readString()
        title = parcel.readString()
        cover_url = parcel.readString()
        clip_num = parcel.readInt()
        play_count = parcel.readInt()
        like_count = parcel.readInt()
        status = parcel.readString()
        user_id = parcel.readString()
        nickname = parcel.readString()
        head_url = parcel.readString()
        is_collect = parcel.readBoolean()
        is_subscribe = parcel.readBoolean()
        is_rate = parcel.readBoolean()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(story_id)
        parcel.writeString(title)
        parcel.writeString(cover_url)
        parcel.writeInt(clip_num)
        parcel.writeInt(play_count)
        parcel.writeInt(like_count)
        parcel.writeString(status)
        parcel.writeString(user_id)
        parcel.writeString(nickname)
        parcel.writeString(head_url)
        parcel.writeBoolean(is_collect)
        parcel.writeBoolean(is_subscribe)
        parcel.writeBoolean(is_rate)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object {

        val CREATOR: Parcelable.Creator<StoryBean?> = object : Parcelable.Creator<StoryBean?> {
            override fun createFromParcel(`in`: Parcel): StoryBean? {
                return StoryBean(`in`)
            }

            override fun newArray(size: Int): Array<StoryBean?> {
                return arrayOfNulls(size)
            }
        }
        const val PUBLISHED = "PUBLISHED" //已发布
        const val INREVIEW = "INREVIEW" //审核中
        const val REJECTED = "REJECTED"
        const val EVALUATE_TRUE = "true"
        const val EVALUATE_FALSE = "false"
    }


}