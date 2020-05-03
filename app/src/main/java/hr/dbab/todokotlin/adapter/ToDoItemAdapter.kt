package hr.dbab.todokotlin.adapter

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import hr.dbab.todokotlin.R
import hr.dbab.todokotlin.database.ToDoItem
import hr.dbab.todokotlin.ui.ToDoViewModel
import kotlinx.android.synthetic.main.todo_item.view.*

class ToDoItemAdapter(
    var toDoItems : List<ToDoItem>,
    private val viewModel: ToDoViewModel
) : RecyclerView.Adapter<ToDoItemAdapter.ToDoViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.todo_item, parent, false)
        return ToDoViewHolder(view)
    }

    override fun getItemCount() = toDoItems.size

    override fun onBindViewHolder(holder: ToDoViewHolder, position: Int) {
        val currentItem = toDoItems[position]
        holder.itemView.tvName.text = currentItem.itemName
        holder.itemView.tvAmount.text = "${currentItem.itemAmount}"

        holder.itemView.checkBox.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked){
                holder.itemView.tvName.apply {
                    paintFlags = paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
                }
            }else {
                holder.itemView.tvName.apply {
                    paintFlags = paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
                }
            }
        }

        holder.itemView.ivDelete.setOnClickListener {
            viewModel.delete(currentItem)
        }
    }


    inner class ToDoViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview)
}