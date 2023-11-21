package com.example.testquest.presentation.roomsScreen

import androidx.recyclerview.widget.DiffUtil
import com.example.testquest.domain.entity.Room
import com.example.testquest.domain.entity.Rooms

class RoomInfoDiffCallback: DiffUtil.ItemCallback<Room>() {

//    override fun areItemsTheSame(oldItem: Rooms, newItem: Rooms): Boolean {
//        return oldItem.room[0].id == newItem.room[1].id
//    }
//
//    override fun areContentsTheSame(oldItem: Rooms, newItem: Rooms): Boolean {
//        return oldItem == newItem
//    }

    override fun areItemsTheSame(oldItem: Room, newItem: Room): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Room, newItem: Room): Boolean {
        return oldItem == newItem
    }
}