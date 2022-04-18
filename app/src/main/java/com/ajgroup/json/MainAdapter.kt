package com.ajgroup.json

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.ajgroup.json.databinding.ItemContentBinding
import com.ajgroup.json.model.GetMovieDiscovery
import com.ajgroup.json.model.Result
import com.bumptech.glide.Glide

class MainAdapter(private val onItemClick: OnClickListener) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    private val diffCallback = object : DiffUtil.ItemCallback<Result>(){
        override fun areItemsTheSame(
            oldItem: Result,
            newItem: Result): Boolean  = oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: Result,
            newItem: Result): Boolean = oldItem.hashCode() == newItem.hashCode()
    }
    private val IMAGE_BASE ="https://image.tmdb.org/t/p/w500/"

    private val differ = AsyncListDiffer(this, diffCallback)

    fun submitData(value: List<Result>) = differ.submitList(value)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(ItemContentBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: MainAdapter.ViewHolder, position: Int) {
        val data = differ.currentList[position]
        data.let { holder.bind(data) }
    }

    override fun getItemCount(): Int = differ.currentList.size

    inner class ViewHolder(private val binding: ItemContentBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Result){
            binding.apply {
                tvJudul.text = data.originalTitle
                tvPrice.text = data.releaseDate
                Glide.with(binding.root).load(IMAGE_BASE+data.posterPath).into(ivHeader)
                root.setOnClickListener {
                    onItemClick.onClickItem(data)
                }
            }
        }
    }
    interface OnClickListener {
        fun onClickItem(data: Result)
    }

}