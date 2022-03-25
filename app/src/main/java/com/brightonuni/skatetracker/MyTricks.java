package com.brightonuni.skatetracker;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.brightonuni.skatetracker.Adapter.MyTricksAdapter;
import com.brightonuni.skatetracker.Adapter.ToDoAdapter;
import com.brightonuni.skatetracker.Model.ToDoModel;
import com.brightonuni.skatetracker.utils.DatabaseHandler;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyTricks extends AppCompatActivity implements DialogCloseListener{
    protected RecyclerView tasksRecyclerView;
    protected MyTricksAdapter TricksAdapter;
    protected FloatingActionButton fab;


    protected List<ToDoModel> checkedTasks;
    protected DatabaseHandler db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notes_layout);



        db = new DatabaseHandler(this);
        db.openDatabase();

        // new array list for values to be displayed
        checkedTasks = new ArrayList<>();

        // set up recyclerView within activity
        tasksRecyclerView = findViewById(R.id.tasksRecyclerView);
        tasksRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        TricksAdapter = new MyTricksAdapter(db,this);
        tasksRecyclerView.setAdapter(TricksAdapter);

        // set task within recyclerView

        checkedTasks = db.getCheckedTasks();
        Collections.reverse(checkedTasks);
        TricksAdapter.setTasks(checkedTasks);

        fab = findViewById(R.id.addFloat);
        fab.hide();

        TextView header = findViewById(R.id.Header);
        header.setText("MY TRICKS");

    }

    /* activity/ list reset when dialogue button closed
     * ensures list updated when user is finished with input
     */

    @Override
    public void handleDialogClose(DialogInterface dialog){
        checkedTasks = db.getAllTasks();
        Collections.reverse(checkedTasks);
        TricksAdapter.setTasks(checkedTasks);
        TricksAdapter.notifyDataSetChanged();
    }

}



