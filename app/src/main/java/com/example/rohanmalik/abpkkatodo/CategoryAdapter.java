package com.example.rohanmalik.abpkkatodo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Rohan Malik on 15-07-2017.
 */

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryHolder> {
    TodoClickListener mClickListener;
    public interface TodoClickListener{
        void onItemClick(View view,int position);
        void onDeleteClick(int position);
    }
    private List<Category_Todo> category_todos;
    public CategoryAdapter(List<Category_Todo> category_todos,TodoClickListener mClickListener){
        this.category_todos=category_todos;
        this.mClickListener=mClickListener;
    }
    @Override
    public CategoryAdapter.CategoryHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_design,parent,false);
        return new CategoryHolder(view,mClickListener);
    }

    @Override
    public void onBindViewHolder(CategoryHolder holder, int position) {
        Category_Todo category_todo = category_todos.get(position);
        holder.category_title.setText(category_todo.getTitle());
        holder.category_count.setText(category_todo.getNumber_category_todo()+ " " + category_todo.getTitle() + " Present");
        holder.category_thumbnail.setImageResource(category_todo.getThumbNail());
    }
    @Override
    public int getItemCount() {
     return category_todos.size();
    }
    class CategoryHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView category_title;
        TextView category_count;
        ImageView category_thumbnail;
        ImageView category_overflow;
        TodoClickListener listenBaby;
        public CategoryHolder(View itemView,TodoClickListener listenBaby) {
            super(itemView);
            itemView.setOnClickListener(this);
            this.listenBaby=listenBaby;
            category_title = (TextView) itemView.findViewById(R.id.category_title);
            category_count = (TextView) itemView.findViewById(R.id.category_count);
            category_thumbnail = (ImageView) itemView.findViewById(R.id.category_cover);
            category_overflow = (ImageView) itemView.findViewById(R.id.overFlow);
            category_overflow.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
                    int id = view.getId();
            int position = getAdapterPosition();
            if(position!=RecyclerView.NO_POSITION){
                if(id==R.id.note_layout){
                    listenBaby.onItemClick(view,position);
                }
                else if(id==R.id.overFlow){
                    listenBaby.onDeleteClick(position);
                }
            }

        }
    }
}
