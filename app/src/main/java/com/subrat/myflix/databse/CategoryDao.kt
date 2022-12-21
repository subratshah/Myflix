package com.subrat.myflix.databse

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.subrat.myflix.model.Category
import io.reactivex.Completable
import kotlinx.coroutines.flow.Flow

@Dao
interface CategoryDao {

    @Query("SELECT * FROM categories")
    fun getCategories(): Flow<List<Category>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCategories(list: List<Category>): Completable

    @Query("DELETE FROM categories")
    fun deleteAllCategories(): Completable
}