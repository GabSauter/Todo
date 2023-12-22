package com.example.todo.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.todo.entities.Todo

@Dao
interface TodoDao {
    @Query("select * from todo")
    suspend fun getAll(): List<Todo>

    @Insert
    suspend fun add(todo: Todo)
}