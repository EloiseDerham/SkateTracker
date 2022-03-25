//package com.brightonuni.skatetracker;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.hardware.SensorEventListener;
//import android.os.Bundle;
//import android.content.Context;
//import android.hardware.Sensor;
//import android.hardware.SensorEvent;
//import android.hardware.SensorEventListener;
//import android.hardware.SensorManager;
//import android.widget.TextView;
//
//public class ShakeDetector implements SensorEventListener {
//
//
//    protected void onResume()
//    {
//        super.onResume();
//        sensorManager.registerListener(this, accSensor, SensorManager.SENSOR_DELAY_NORMAL);
//    }
//
//    public void onSensorChanged(SensorEvent event)
//
//
//    }
//
//    @Override
//    protected void onPause()
//    {
//        super.onPause();
//
//        sensorManager.unregisterListener(this, accSensor);
//    }
//
//    public void onAccuracyChanged(Sensor sensor, int accuracy)
//    {
//
//    }
//
//}
