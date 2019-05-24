package com.example.firebaseapp;

import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.firebase.client.Firebase;


public class MainActivity extends AppCompatActivity {


private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.buttonswitch);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openaddData();
            }
        });

    }
    public void openaddData() {
        Intent intent = new Intent(this, addData.class);
        startActivity(intent);
    }
}
