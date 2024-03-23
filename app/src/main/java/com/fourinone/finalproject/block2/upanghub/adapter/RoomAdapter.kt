package com.fourinone.finalproject.block2.upanghub.adapter

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.fourinone.finalproject.block2.upanghub.RoomViewActivity
import com.fourinone.finalproject.block2.upanghub.databinding.RoomListBinding
import com.fourinone.finalproject.block2.upanghub.model.Room

class RoomAdapter(var roomList: MutableList<Room>):RecyclerView.Adapter<RoomAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: RoomListBinding): RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoomAdapter.ViewHolder {
        val view = RoomListBinding.inflate(LayoutInflater.from(parent.context), parent , false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = roomList[position]

        holder.binding.apply {

            // Bind other views here if needed

            tvRoomName.text = currentItem.room_code

            rvList.setOnClickListener {
                // Replace "urlToOpen" with the URL you want to open
                val intent = Intent(holder.itemView.context, RoomViewActivity::class.java)
                intent.putExtra("key", currentItem.id.toString())
                holder.itemView.context.startActivity(intent)
            }

        }

    }


    override fun getItemCount(): Int {
        return roomList.size
    }

    fun updateData(newDataset: List<Room>) {
        roomList = newDataset as MutableList<Room>
        notifyDataSetChanged() // Notify the adapter that the dataset has changed
    }

}