package hr.dbab.todokotlin.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ToDoDao {

    // defining a function for inserting an item in our database
    // if there is an object already we will replace it
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(toDoItem: ToDoItem)

    // defining a function for deleting an item
    @Delete
    suspend fun delete(toDoItem: ToDoItem)

    // defining a function for getting all the items from database
    @Query("SELECT * FROM todo_items")
    fun getAllItems() : LiveData<List<ToDoItem>>
}