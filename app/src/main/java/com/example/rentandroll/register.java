package com.example.rentandroll;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.util.Log;
import android.widget.EditText;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class register extends AppCompatActivity {
    Button button;
    EditText name, usr_name, password, Phone_Number, Email, city;
    String name_1, usr_name_1, password_1, Phone_Number_1, Email_1, city_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name = findViewById(R.id.name);
        usr_name = findViewById(R.id.usr_name);
        password = findViewById(R.id.password);
        Phone_Number = findViewById(R.id.Phone_Number);
        Email = findViewById(R.id.Email);
        city = findViewById(R.id.city);
        button = findViewById(R.id.button_register);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name_1=name.getText().toString();
                usr_name_1=usr_name.getText().toString();
                password_1=password.getText().toString();
                Phone_Number_1=Phone_Number.getText().toString();
                Email_1=Email.getText().toString();
                city_1=city.getText().toString();

                RequestQueue requestQueue = Volley.newRequestQueue(register.this);
                String url = "http://192.168.163.65/RentAndRoll/SourceCode/admin/json_api/register.php";
                StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {                    @Override
                public void onResponse(String response) {
                    if(response.equals("success")){
                        Toast.makeText(register.this, "Registration successfully", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(register.this, home.class);
                        startActivity(i);
                        finish();
                    }else{
                        Toast.makeText(register.this, "something went wrong", Toast.LENGTH_SHORT).show();
                    }
                }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(register.this, "Error in registration "+error, Toast.LENGTH_LONG).show();
//                        Log.d("error register",error);
                    }
                }){
                    protected Map<String, String> getParams() {
                        Map<String, String> paramV = new HashMap<>();

                        paramV.put("name", name_1);
                        paramV.put("usr_name", usr_name_1);
                        paramV.put("password", password_1);
                        paramV.put("Phone_Number", Phone_Number_1);
                        paramV.put("Email", Email_1);
                        paramV.put("city", city_1);


                        return paramV;
                    }
                };
                requestQueue.add(request);
            }
        });
    }
}
