package com.example.newyorker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.FirebaseDatabase;

public class LoginActivity extends AppCompatActivity {
    private EditText Email, Password;
    private Button Login;
    private FirebaseDatabase DBRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
//        FirebaseDatabase DBRef= FirebaseDatabase.getInstance();
//
//        DBRef = new FirebaseDatabase();

        Email = findViewById(R.id.email);
        Password = findViewById(R.id.password);
        Login = findViewById(R.id.login);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(Email.getText().toString(), Password.getText().toString());
            }
        });
    }

    private void validate(String userName, String userPassword){
        if ((userName.equals("saloua1998@live.nl")) && (userPassword.equals("test"))){
            Intent intent = new Intent(LoginActivity.this, Inventory.class);
            startActivity(intent);
        }else{
            Toast.makeText(LoginActivity.this, "Verkeer wachtwoord of naam ingevoerd", Toast.LENGTH_SHORT).show();
        }
    }
}
