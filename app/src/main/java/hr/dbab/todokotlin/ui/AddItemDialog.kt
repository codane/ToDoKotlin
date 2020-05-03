package hr.dbab.todokotlin.ui

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import hr.dbab.todokotlin.R
import hr.dbab.todokotlin.database.ToDoItem
import kotlinx.android.synthetic.main.dialog_add_item.*

class AddItemDialog(context: Context, var addDialogListener: AddDialogListener): AppCompatDialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_add_item)

        tvAdd.setOnClickListener {
            val name = etName.text.toString()
            val amount = etAmount.text.toString()

            if (name.isEmpty() || amount.isEmpty()){
                Toast.makeText(context, "You did not enter everything", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val newTaskItem =
                ToDoItem(name, amount.toInt())
            addDialogListener.onAddButtonClicked(newTaskItem)
            dismiss()
        }

        tvCancel.setOnClickListener {
            cancel()
        }
    }
}