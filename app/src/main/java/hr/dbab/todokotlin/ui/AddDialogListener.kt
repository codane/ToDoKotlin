package hr.dbab.todokotlin.ui

import hr.dbab.todokotlin.database.ToDoItem

interface AddDialogListener {

    fun onAddButtonClicked(toDoItem: ToDoItem)
}