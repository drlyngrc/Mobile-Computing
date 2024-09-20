package com.activity.app;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Signup extends AppCompatActivity {

    private FirebaseAuth auth;

    EditText editemail, editpassword, editname, editusername;
    Button signUp;
    ProgressBar move;
    TextView login;
    FirebaseDatabase database;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        auth =  FirebaseAuth.getInstance();

        editemail = findViewById(R.id.signup_email);
        editpassword = findViewById(R.id.signup_password);
        editname = findViewById(R.id.signup_name);
        editusername = findViewById(R.id.signup_username);
        signUp = findViewById(R.id.signup_button);
        move = findViewById(R.id.move);
        login = findViewById(R.id.loginNow);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                database = FirebaseDatabase.getInstance();
                reference = database.getReference("Users");

                move.setVisibility(View.VISIBLE);
                String email = editemail.getText().toString().trim();
                String password = editpassword.getText().toString().trim();
                String name = editname.getText().toString().trim();
                String username = editusername.getText().toString().trim();

                HelperClass helperClass = new HelperClass(name, email, username, password);
                reference.child(username).setValue(helperClass);

                if (name.isEmpty()) {
                    Toast.makeText(Signup.this, "Empty name.", Toast.LENGTH_SHORT).show();
                    move.setVisibility(View.GONE);
                    return;
                }
                if (email.isEmpty()) {
                    Toast.makeText(Signup.this, "Empty email address.", Toast.LENGTH_SHORT).show();
                    move.setVisibility(View.GONE);
                    return;
                } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    Toast.makeText(Signup.this, "Invalid email.", Toast.LENGTH_SHORT).show();
                    move.setVisibility(View.GONE);
                    return;
                }
                if (username.isEmpty()) {
                    Toast.makeText(Signup.this, "Empty username.", Toast.LENGTH_SHORT).show();
                    move.setVisibility(View.GONE);
                    return;
                }
                if (password.isEmpty()) {
                    Toast.makeText(Signup.this, "Provide a password.", Toast.LENGTH_SHORT).show();
                    move.setVisibility(View.GONE);
                    return;
                } else {
                    auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(Signup.this, "Sign Up Successful.", Toast.LENGTH_SHORT).show();
                                move.setVisibility(View.GONE);
                                startActivity(new Intent(Signup.this, Login.class));
                                finish();
                            } else {
                                Toast.makeText(Signup.this, "Sign Up Failed." + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                move.setVisibility(View.GONE);
                            }
                        }
                    });
                }
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Signup.this, Login.class));
                finish();
            }
        });

    }

}
