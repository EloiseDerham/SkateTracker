package com.brightonuni.skatetracker;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.brightonuni.skatetracker.Adapter.ToDoAdapter;
import com.brightonuni.skatetracker.Model.ToDoModel;
import com.brightonuni.skatetracker.utils.DatabaseHandler;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Notes extends AppCompatActivity implements DialogCloseListener{
    protected RecyclerView tasksRecyclerView;
    protected ToDoAdapter tasksAdapter;
    protected FloatingActionButton fab;
    protected Button delbut;

    protected List<ToDoModel> taskList;
    protected DatabaseHandler db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notes_layout);


        db = new DatabaseHandler(this);
        db.openDatabase();

        // new array list for values to be displayed
        taskList = new ArrayList<>();

        // set up recyclerView within activity
        tasksRecyclerView = findViewById(R.id.tasksRecyclerView);
        tasksRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        tasksAdapter = new ToDoAdapter(db,this);
        tasksRecyclerView.setAdapter(tasksAdapter);

        // set task within recyclerView

        taskList = db.getAllTasks();
        Collections.reverse(taskList);
        tasksAdapter.setTasks(taskList);

        // open bottom dialogue fragment for users to input new task when add float clicked
        fab = findViewById(R.id.addFloat);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddNewTask.newInstance().show(getSupportFragmentManager(),AddNewTask.TAG);
            }
        });

//        delbut = findViewById(R.id.deleteButton);
//
//        delbut.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                int position = viewHolder.getAdapterPosition();
//                tasksAdapter.deleteTask(position);
//            }
//        });
    }

    /* activity/ list reset when dialogue button closed
     * ensures list updated when user is finished with input
     */

    @Override
    public void handleDialogClose(DialogInterface dialog){
        taskList = db.getAllTasks();
        Collections.reverse(taskList);
        tasksAdapter.setTasks(taskList);
        tasksAdapter.notifyDataSetChanged();
    }

}
