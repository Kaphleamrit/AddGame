package com.example.mathstester;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void startMainActivity(View view) {



        Intent intent = new Intent(MainActivity.this, startActivity.class);

        startActivity(intent);
    }
}