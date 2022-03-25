package com.brightonuni.skatetracker;

import android.os.Bundle;
import android.widget.TextView;

    public class Goals extends Notes {

        //extend layout and functionality of notes class
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            TextView header = findViewById(R.id.Header);
            header.setText("GOALS");

        }

    }

