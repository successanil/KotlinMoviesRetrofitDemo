/*
 * Copyright (c) 2020. Relsell Global
 */

package com.relsellglobal.moviesretrofitdemo.businesslogic.ui


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.relsellglobal.moviesretrofitdemo.R
import com.relsellglobal.moviesretrofitdemo.businesslogic.ui.dummy.DummyContent.DummyItem
import com.relsellglobal.moviesretrofitdemo.businesslogic.ui.pojo.Blog
import kotlinx.android.synthetic.main.fragment_movie_item.view.*

/**
 * [RecyclerView.Adapter] that can display a [DummyItem] and makes a call to the
 * specified [OnListFragmentInteractionListener].
 * TODO: Replace the implementation with code for your data type.
 */
class BlogItemRecyclerViewAdapter(
    private val mValues: List<Blog>
) : RecyclerView.Adapter<BlogItemRecyclerViewAdapter.ViewHolder>() {

    private val mOnClickListener: View.OnClickListener

    init {
        mOnClickListener = View.OnClickListener { v ->
            val item = v.tag as Blog
            // Notify the active callbacks interface (the activity, if the fragment is attached to
            // one) that an item has been selected.
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_movie_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mValues[position]
        holder.nameTV.text = item.name
        holder.yearTV.text = item.year
//
//        with(holder.mView) {
//            tag = item
//            setOnClickListener(mOnClickListener)
//        }
    }

    override fun getItemCount(): Int = mValues.size

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val nameTV: TextView = mView.name
        val yearTV: TextView = mView.year

    }
}
