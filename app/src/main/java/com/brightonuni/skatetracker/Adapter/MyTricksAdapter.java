package com.brightonuni.skatetracker.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.brightonuni.skatetracker.Model.ToDoModel;
import com.brightonuni.skatetracker.MyTricks;
import com.brightonuni.skatetracker.R;
import com.brightonuni.skatetracker.utils.DatabaseHandler;

import java.util.List;

public class MyTricksAdapter extends RecyclerView.Adapter<MyTricksAdapter.ViewHolder> {

    private List<ToDoModel> todoList;
    private MyTricks activity;
    private DatabaseHandler db;

    public MyTricksAdapter(DatabaseHandler db, MyTricks activity){
        this.db = db;
        this.activity = activity;
    }

// create view holder for the task layout

    public ViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.task_layout2,parent, false);
        return new ViewHolder(itemView);
    }

    /* set list view linked to database values
     * using ToDoModel to organise database data and assign values
     * assign checked change listener to checkbox and using db method to update values when checked
     */

    public void onBindViewHolder(ViewHolder holder, int position){
        db.openDatabase();
        ToDoModel item = todoList.get(position);
        holder.task.setText(item.getTask());
//        holder.task.setChecked(toBoolean(item.getStatus()));
//        holder.task.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked){
//                    db.updateStatus(item.getId(),1);
//                    Toast toast = Toast.makeText( getContext(), "Well Done!" , Toast.LENGTH_LONG);
//                    toast.show();
//                }else{
//                    db.updateStatus(item.getId(),0);
//                }
//            }
//        });
    }

    // return list length
    public int getItemCount(){
        return todoList.size();
    }
    private boolean toBoolean(int n)
    {
        return n!=0;
    }

    // assign new tasks and set values
    public void setTasks(List<ToDoModel> todoList){
        this.todoList = todoList;
        notifyDataSetChanged();
    }

    public void deleteTask(int position){
        ToDoModel item = todoList.get(position);
        db.delete(item.getId());
        todoList.remove(position);
        notifyItemRemoved(position);
    }

    public Context getContext(){
        return activity;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        CheckBox task;
        ViewHolder(View view){
            super(view);
            task = view.findViewById(R.id.achievedCheckBox);
        }
    }
}
