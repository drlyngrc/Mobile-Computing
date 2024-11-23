package com.activity.mobcom.Activity.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.activity.mobcom.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignupActivity extends AppCompatActivity {

    private FirebaseAuth auth;
    private DatabaseReference databaseReference;

    EditText editemail, editpassword, editname, editusername;
    Button signUp;
    ProgressBar move;
    TextView login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

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

                auth =  FirebaseAuth.getInstance();
                databaseReference = FirebaseDatabase.getInstance().getReference("Users");

                move.setVisibility(View.VISIBLE);
                String email = editemail.getText().toString().trim();
                String password = editpassword.getText().toString().trim();
                String name = editname.getText().toString().trim();
                String username = editusername.getText().toString().trim();

                if (name.isEmpty()) {
                    Toast.makeText(SignupActivity.this, "Empty name.", Toast.LENGTH_SHORT).show();
                    move.setVisibility(View.GONE);
                    return;
                }
                if (email.isEmpty()) {
                    Toast.makeText(SignupActivity.this, "Empty email address.", Toast.LENGTH_SHORT).show();
                    move.setVisibility(View.GONE);
                    return;
                }
                if (username.isEmpty()) {
                    Toast.makeText(SignupActivity.this, "Empty username.", Toast.LENGTH_SHORT).show();
                    move.setVisibility(View.GONE);
                    return;
                }
                if (password.isEmpty()) {
                    Toast.makeText(SignupActivity.this, "Provide a password.", Toast.LENGTH_SHORT).show();
                    move.setVisibility(View.GONE);
                    return;
                } else {
                    auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Use username as the key instead of user ID
                                User userInfo = new User(name, email, username);

                                // Save user information with the username as the key
                                databaseReference.child(username).setValue(userInfo).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful()) {
                                            Toast.makeText(SignupActivity.this, "Sign Up Successful.", Toast.LENGTH_SHORT).show();
                                            move.setVisibility(View.GONE);
                                            startActivity(new Intent(SignupActivity.this, LoginActivity.class));
                                            finish();
                                        } else {
                                            Toast.makeText(SignupActivity.this, "Data Save Failed: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                            move.setVisibility(View.GONE);
                                        }
                                    }
                                });

                                SharedPreferences sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE);
                                SharedPreferences.Editor editor = sharedPreferences.edit();
                                editor.putString("userName", name);
                                editor.putString("userEmail", email);
                                editor.putString("userUsername", username);
                                editor.apply();


                            } else {
                                if (task.getException() instanceof FirebaseAuthUserCollisionException) {
                                    Toast.makeText(SignupActivity.this, "This email is already registered.", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(SignupActivity.this, "Sign Up Failed. Please try again.", Toast.LENGTH_SHORT).show();
                                }
                                //Toast.makeText(SignupActivity.this, "Sign Up Failed: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
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
                startActivity(new Intent(SignupActivity.this, LoginActivity.class));
                finish();
            }
        });
    }

    // User model to store additional data
    public static class User {
        public String name, email, username;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public User(String name, String email, String username) {
            this.name = name;
            this.email = email;
            this.username = username;
        }

        public User() {
        }
    }

}
