package com.example.retrofitexample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.retrofitexample.databinding.FragmentFirstBinding
import com.example.retrofitexample.databinding.RvMarsPictureBinding
import com.example.retrofitexample.remote.MarsRealState

class MarsAdapter : RecyclerView.Adapter<MarsAdapter.MarsVH>()  {

    private var listPictures = listOf<MarsRealState>()

    private val selectedTaskItem = MutableLiveData<MarsRealState>()

    fun selectedItem():LiveData<MarsRealState> = selectedTaskItem

    fun update(list: List<MarsRealState>){
        listPictures = list
        notifyDataSetChanged()
    }
    inner class MarsVH (private val binding: RvMarsPictureBinding):
            RecyclerView.ViewHolder(binding.root),View.OnClickListener{
            fun bind(task : MarsRealState){
                Glide.with(binding.imageView).load(task.imgSrc).into(binding.imageView)
                itemView.setOnClickListener(this)

            }
        override fun onClick(v: View?) {
        selectedTaskItem.value = listPictures[adapterPosition]
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarsVH {
            return MarsVH(RvMarsPictureBinding.inflate(LayoutInflater.from(parent.context)))
    }
    override fun onBindViewHolder(holder: MarsVH, position: Int) {
        val task = listPictures[position]
            holder.bind(task)
    }
    override fun getItemCount(): Int = listPictures.size

}