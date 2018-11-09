package com.example.android.perch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TESTING PARKING SPACE CREATION
        Intent intent = new Intent(MainActivity.this, ListParkingSpaceActivity.class);
        startActivity(intent);
    }
}
