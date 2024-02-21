package com.example.rentandroll;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class home extends AppCompatActivity {
    private Button button1;
    private ImageButton button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        button1 = (Button) findViewById(R.id.button_csbook);
        button2 = (ImageButton) findViewById(R.id.button_profile);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openactivity_booking();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openactivity_Profile();
            }
        });
    }
    public void openactivity_booking() {
        Intent intent = new Intent(this, Booking.class);
        startActivity(intent);
    }
    public void openactivity_Profile() {
        Intent intent = new Intent(this, profile.class);
        startActivity(intent);
    }
}