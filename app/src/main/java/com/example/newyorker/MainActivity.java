package com.example.newyorker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText Name;
    private EditText Password;
    private Button Login;
    private int Counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name = findViewById(R.id.name);
        Password = findViewById(R.id.password);
        Login = findViewById(R.id.login);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(Name.getText().toString(), Password.getText().toString());
            }
        });
    }

    private void validate(String userName, String userPassword){
        if ((userName.equals("Saloua")) && (userPassword.equals("test"))){
            Intent intent = new Intent(MainActivity.this, Inventory.class);
            startActivity(intent);
        }else{
            Toast.makeText(MainActivity.this, "Verkeer wachtwoord of naam ingevoerd", Toast.LENGTH_SHORT).show();
        }
    }
}
