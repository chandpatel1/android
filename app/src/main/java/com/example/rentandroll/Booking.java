package com.example.rentandroll;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Booking extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        button = (Button) findViewById(R.id.button_book);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openactivity_bookingconfirmed();
            }
        });

    }
    public void openactivity_bookingconfirmed() {
        Intent intent = new Intent(this, bookingconfirmed.class);
        startActivity(intent);
    }
}