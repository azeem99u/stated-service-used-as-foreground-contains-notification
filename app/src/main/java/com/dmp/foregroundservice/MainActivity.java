package com.dmp.foregroundservice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.et1);
        findViewById(R.id.btnRun).setOnClickListener(view -> {
            String text = editText.getText().toString();
            //startService(new Intent(getApplicationContext(),ExampleService.class).putExtra("et1",text));
            ContextCompat.startForegroundService(this,new Intent(getApplicationContext(),ExampleService.class).putExtra("et1",text));
        });

        findViewById(R.id.btnStop).setOnClickListener(view -> {
            stopService(new Intent(getApplicationContext(),ExampleService.class));
        });
    }
}