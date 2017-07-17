package com.example.rohanmalik.abpkkatodo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Rohan Malik on 16-07-2017.
 */

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.ToDoHolder> {
    List<Lists> list_ToDo;

    public TodoAdapter(List<Lists> list_ToDo) {
        this.list_ToDo = list_ToDo;
    }

    @Override
    public TodoAdapter.ToDoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list,parent,false);
        return new ToDoHolder(view);
    }

    @Override
    public void onBindViewHolder(ToDoHolder holder, int position) {
            Lists listItem= list_ToDo.get(position);
        holder.titleToDo.setText(listItem.getTitle());

    }

    @Override
    public int getItemCount() {
      return list_ToDo.size();
    }
    class ToDoHolder extends RecyclerView.ViewHolder {
        TextView titleToDo;
        CheckBox checkBox;
        public ToDoHolder(View itemView) {
            super(itemView);
            titleToDo = (TextView)itemView.findViewById(R.id.RohanTitle);
            checkBox = (CheckBox)itemView.findViewById(R.id.checkingbro);
        }
    }
}
