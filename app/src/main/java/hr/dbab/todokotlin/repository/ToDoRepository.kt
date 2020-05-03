package hr.dbab.todokotlin.repository

import hr.dbab.todokotlin.database.ToDoDatabase
import hr.dbab.todokotlin.database.ToDoItem

class ToDoRepository(private val toDoDatabase: ToDoDatabase) {

    // implementing functions from ToDoDao
    // Room executes all queries on a separate thread.

    suspend fun insert(toDoItem: ToDoItem) = toDoDatabase.toDoDao.insert(toDoItem)


    suspend fun delete(toDoItem: ToDoItem) = toDoDatabase.toDoDao.delete(toDoItem)


    fun getAllItems() = toDoDatabase.toDoDao.getAllItems()
}