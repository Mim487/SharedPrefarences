package com.example.sharedprefarences;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    TextView name,email,number,password;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        number = findViewById(R.id.number);
        password = findViewById(R.id.password);

        sharedPreferences = getSharedPreferences("" + getString(R.string.app_name),MODE_PRIVATE);

        String name1 = sharedPreferences.getString("name","Default");
        String email1 = sharedPreferences.getString("email","Default");
        String number1 = sharedPreferences.getString("number","Default");
        String password1 = sharedPreferences.getString("password","Default");


        name.setText(name1);
        email.setText(email1);
        number.setText(number1);
        password.setText(password1);
    }
}