package com.subrat.myflix.databse

import androidx.room.Database
import androidx.room.RoomDatabase
import com.subrat.myflix.model.Category

@Database(
    entities = [Category::class],
    version = 1
)
abstract class CategoryDatabase : RoomDatabase() {
    abstract fun dao(): CategoryDao
}