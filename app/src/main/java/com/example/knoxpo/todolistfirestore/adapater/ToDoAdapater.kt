package com.example.knoxpo.todolistfirestore.adapater

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.TextView
import android.widget.Toast
import com.example.knoxpo.todolistfirestore.Model.ToDoModel
import com.example.knoxpo.todolistfirestore.R
import kotlinx.android.synthetic.main.todo_list_row.view.*

class ToDoAdapater(var mToDoList: List<ToDoModel>) : RecyclerView.Adapter<ToDoAdapater.MyViewHolder>() {


    var onClickListener: OnClickListener? = null


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolder {

        val view: View = LayoutInflater.from(p0.context).inflate(R.layout.todo_list_row, p0, false)

        return MyViewHolder(view)
    }

    override fun getItemCount() = mToDoList.size

    override fun onBindViewHolder(p0: MyViewHolder, p1: Int) {

        val mToDoModel: ToDoModel = mToDoList[p1]

        p0.bindData(mToDoModel)
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val mTextViewTitle: TextView = itemView.textViewTitle
        private val mCheckBox: CheckBox? = itemView.checkBox

        fun bindData(mToDoModel: ToDoModel) {


            mTextViewTitle.text = mToDoModel.title
            mCheckBox?.isChecked = mToDoModel.isCheck!!

            mCheckBox?.setOnClickListener {

                onClickListener?.onClickUpdate(mToDoModel.id,mToDoModel.isCheck)

            }

        }


    }

    interface OnClickListener {


        fun onClickUpdate(mToDoModel: String?, check: Boolean?)

        fun onClickDelete(mToDoModel: ToDoModel, adapterPosition: Int)
    }


}