package com.example.sharedprefarences;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    AppCompatButton save,next;
    AppCompatEditText name,email,number,password;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        next = findViewById(R.id.next);
        save = findViewById(R.id.save);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        number = findViewById(R.id.number);
        password = findViewById(R.id.password);


        sharedPreferences = getSharedPreferences("" + getString(R.string.app_name),MODE_PRIVATE);
        editor = sharedPreferences.edit();

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name1 = name.getText().toString().trim();
                String email1 = email.getText().toString().trim();
                String number1 = number.getText().toString().trim();
                String password1 = password.getText().toString().trim();


                editor.putString("name",name1);
                editor.putString("email",email1);
                editor.putString("number",number1);
                editor.putString("password",password1);
                editor.apply();
            }
        });


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent next = new Intent(MainActivity.this,MainActivity2.class);
                startActivity(next);

            }
        });

        OnBackPressedDispatcher onBackPressedDispatcher = getOnBackPressedDispatcher();
        onBackPressedDispatcher.addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                showDialouge();



            }

        });



    }

    private void showDialouge(){
        new AlertDialog.Builder(MainActivity.this)
                .setIcon(R.drawable.warning)
                .setTitle("Warning")
                .setMessage("Are you sure exit the app")
                .setCancelable(false)
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                })
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        finish();
                    }
                })
                .show();
    }


}