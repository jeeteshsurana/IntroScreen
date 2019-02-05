package com.justcodenow.introscreen

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


/**
 * Created by Abhin.
 */
class IntroScreenAdapter(var mContext: Context, var IntroArrayList: ArrayList<IntroModel>) :
    RecyclerView.Adapter<IntroScreenAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_intro_screen, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return IntroArrayList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(position, mContext, IntroArrayList)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var galleryImage: ImageView = itemView.findViewById(R.id.img_item_intro)
        @SuppressLint("ClickableViewAccessibility")
        fun bindView(position: Int, mContext: Context, galleryList: ArrayList<IntroModel>) {

            Glide.with(mContext)
                .load(galleryList[position].introImage)
                .into(galleryImage)

            itemView.onFocusChangeListener = View.OnFocusChangeListener { v, hasFocus ->
                if (hasFocus) {
                    val anim = AnimationUtils.loadAnimation(mContext, R.anim.scale_in)
                    itemView.startAnimation(anim)
                    anim.fillAfter = true
                } else {
                    // run scale animation and make it smaller
                    val anim = AnimationUtils.loadAnimation(mContext, R.anim.scale_out)
                    itemView.startAnimation(anim)
                    anim.fillAfter = true
                }
            }
        }
    }
}