package com.brightonuni.skatetracker;



import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button goals,tricks,random,map;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        goals = (Button) findViewById(R.id.goals);
        goals.setOnClickListener(this);
        tricks = (Button) findViewById(R.id.tricks);
        tricks.setOnClickListener(this);
        random = (Button) findViewById(R.id.random);
        random.setOnClickListener(this);
        map = (Button) findViewById(R.id.map);
        map.setOnClickListener(this);
    }

    public void onClick (View v) {
        switch (v.getId()) {
            case R.id.goals:
                //switches activity if button pressed
                Intent i = new Intent(MainActivity.this, Goals.class);
                startActivity(i);
                break;
            case R.id.tricks:
                Intent x = new Intent(MainActivity.this, MyTricks.class);
                startActivity(x);
                  break;
            case R.id.random:
               Intent y = new Intent(MainActivity.this, TrickGenerator.class);
               startActivity(y);
                break;
            case R.id.map:
                break;
            default:
                break;

        }

    }
}