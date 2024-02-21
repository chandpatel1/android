package com.example.rentandroll;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button button1,button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button) findViewById(R.id.button_hlog);
        button2 = (Button) findViewById(R.id.button_hreg);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openactivity_login();

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openactivity_register();

            }
        });

    }
    public void openactivity_login(){
        Intent intent = new Intent(this,login.class);
        startActivity(intent);
    }
    public void openactivity_register(){
        Intent intent = new Intent(this, register.class);
        startActivity(intent);
    }
}