package com.example.testquest.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.testquest.data.database.bookingDao.BookingInfoDao
import com.example.testquest.data.database.bookingDao.BookingInfoDbModel
import com.example.testquest.data.database.hotelDao.HotelInfoDao
import com.example.testquest.data.database.hotelDao.HotelInfoDbModel
import com.example.testquest.data.database.roomDao.RoomInfoDao
import com.example.testquest.data.database.roomDao.RoomInfoDbModel

@Database(
    entities = [HotelInfoDbModel::class, RoomInfoDbModel::class, BookingInfoDbModel::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class AppDatabase: RoomDatabase() {

    companion object {

        private var db: AppDatabase? = null
        private const val DB_NAME = "main.db"
        private val LOCK = Any()

        fun getInstance(context: Context): AppDatabase {
            synchronized(LOCK) {
                db?.let { return it }
                val instance =
                    Room.databaseBuilder(
                        context,
                        AppDatabase::class.java,
                        DB_NAME
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                db = instance
                return instance
            }
        }

    }


    abstract fun hotelInfoDao(): HotelInfoDao
    abstract fun roomInfoDao(): RoomInfoDao
    abstract fun bookingInfoDao(): BookingInfoDao

}