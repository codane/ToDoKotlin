package hr.dbab.todokotlin.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import hr.dbab.todokotlin.*
import hr.dbab.todokotlin.adapter.ToDoItemAdapter
import hr.dbab.todokotlin.database.ToDoItem
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {

    // getting a reference to our ViewModel using Koin
    val viewModel: ToDoViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter =
            ToDoItemAdapter(listOf(), viewModel)
        rvToDoItems.layoutManager = LinearLayoutManager(this)
        rvToDoItems.adapter = adapter

        //displaying all the items from our database
        viewModel.getAllItems().observe(this, Observer {
            adapter.toDoItems = it
            adapter.notifyDataSetChanged()

        })

        fabAddItem.setOnClickListener {
            AddItemDialog(this,
                object : AddDialogListener {
                    override fun onAddButtonClicked(toDoItem: ToDoItem) {
                        viewModel.insert(toDoItem)
                    }
                }).show()
        }
    }
}
