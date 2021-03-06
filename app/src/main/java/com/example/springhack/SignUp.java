package com.example.springhack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class SignUp extends AppCompatActivity {
    String name;
    String firstName;
    Button signUp;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef;
    private FirebaseAuth mAuth;

    FirebaseUser user = mAuth.getInstance().getCurrentUser();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        name = ((EditText) findViewById(R.id.name)).getText().toString();
        firstName = ((EditText) findViewById(R.id.firstname)).getText().toString();

        signUp = findViewById(R.id.confirm2);
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = ((EditText) findViewById(R.id.name)).getText().toString();
                firstName = ((EditText) findViewById(R.id.firstname)).getText().toString();
                myRef = database.getReference();
                myRef.child("users").child(user.getUid()).child("name").setValue(name);
                myRef.child("users").child(user.getUid()).child("surname").setValue(firstName);
                Intent intent = new Intent(SignUp.this, Hero.class);
                startActivity(intent);
            }
        });
    }
}
