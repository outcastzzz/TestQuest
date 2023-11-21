package com.example.testquest.presentation.roomsScreen

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.testquest.databinding.RoomItemBinding
import com.example.testquest.domain.entity.Room
import com.example.testquest.domain.entity.Rooms

class RoomItemAdapter(
    private val context: Context
): ListAdapter<Room, RoomInfoViewHolder>(RoomInfoDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoomInfoViewHolder {
        val binding = RoomItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return RoomInfoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RoomInfoViewHolder, position: Int) {
        val room = getItem(position)
        with(holder.binding) {
            for (i in 0..1) {
                roomTitle.text = room.name
                roomPrice.text = room.price.toString()
                roomTourLength.text = room.pricePer
                roomIncludeTitle.text = room.peculiarities[0]
                conditionerInclude.text = room.peculiarities[1]
            }
        }
    }
}