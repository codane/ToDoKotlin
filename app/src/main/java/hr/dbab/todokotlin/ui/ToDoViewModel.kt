package hr.dbab.todokotlin.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import hr.dbab.todokotlin.repository.ToDoRepository
import hr.dbab.todokotlin.database.ToDoItem
import kotlinx.coroutines.launch

class ToDoViewModel(
    private val repository: ToDoRepository
) : ViewModel() {


    // starting a new coroutine in viewmodelscope -> it uses Dispatcher.Main by default
    fun insert(toDoItem: ToDoItem) = viewModelScope.launch {
        repository.insert(toDoItem)
    }

    fun delete(toDoItem: ToDoItem) = viewModelScope.launch {
        repository.delete(toDoItem)
    }

    fun getAllItems() = repository.getAllItems()


}