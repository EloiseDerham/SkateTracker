package com.brightonuni.skatetracker;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.SensorEventListener;
import android.os.Bundle;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.FloatMath;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TrickGenerator extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor accSensor;
    private static final float SHAKE_THRESHOLD_GRAVITY = 2.5F;
    protected TextView newTrick;
    List<String> EasyTrickList = Arrays.asList("Ollie", "Shuvit","Backside 180", "Manual","Kickturn","Pushing");
    List<String> IntermediateTrickList = Arrays.asList("Kickflip","Frontside 180", "Pop Shuvit", "Heelflip");
    List<String> HardTrickList = Arrays.asList("Hardflip","LaserFlip","360 flip");
    String Level;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trick_generator);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        accSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        newTrick = findViewById(R.id.randomTrick);


    }


    protected void onResume()
    {
        super.onResume();
        sensorManager.registerListener(this, accSensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    public void onSensorChanged(SensorEvent event) {
        if (accSensor != null) {
            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];

            float gX = x / SensorManager.GRAVITY_EARTH;
            float gY = y / SensorManager.GRAVITY_EARTH;
            float gZ = z / SensorManager.GRAVITY_EARTH;

            // gForce will be close to 1 when there is no movement.
            float gForce = (float) Math.sqrt(gX * gX + gY * gY + gZ * gZ);

            System.out.println(gForce);

            if (gForce > SHAKE_THRESHOLD_GRAVITY) {
                int rand = (int)Math.floor(Math.random() * EasyTrickList.size());
                newTrick.setText(EasyTrickList.get(rand));
            }
        }
    }

        @Override
        protected void onPause()
        {
            super.onPause();
            sensorManager.unregisterListener(this, accSensor);
        }

        public void onAccuracyChanged (Sensor accSensor,int accuracy)
        {

        }

    }
