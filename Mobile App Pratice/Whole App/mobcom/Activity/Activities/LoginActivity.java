package com.activity.mobcom.Activity.Activities;

import static android.app.ProgressDialog.show;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.activity.mobcom.Navigation.Main;
import com.activity.mobcom.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth auth;

    EditText editemail, editpassword;
    Button login;
    ProgressBar move;
    TextView signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        auth =  FirebaseAuth.getInstance();

        editemail = findViewById(R.id.email);
        editpassword = findViewById(R.id.password);
        login = findViewById(R.id.login_button);
        move = findViewById(R.id.move);
        signup = findViewById(R.id.signupNow);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                move.setVisibility(View.VISIBLE);
                String email = String.valueOf(editemail.getText());
                String password = String.valueOf(editpassword.getText());

                if(!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    if(!password.isEmpty()){
                        auth.signInWithEmailAndPassword(email,password)
                                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                                    @Override
                                    public void onSuccess(AuthResult authResult) {
                                        Toast.makeText(LoginActivity.this, "Login Successful.", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(LoginActivity.this, Main.class));
                                        finish();
                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(LoginActivity.this, "Login Failed.", Toast.LENGTH_SHORT).show();
                                    }
                                });

                    } else {
                        Toast.makeText(LoginActivity.this, "Provide a password.",
                                Toast.LENGTH_SHORT).show();
                        return;
                    }
                } else if (email.isEmpty()){
                    Toast.makeText(LoginActivity.this, "Provide an email address.",
                            Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    Toast.makeText(LoginActivity.this, "Invalid email.",
                            Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, SignupActivity.class));
                finish();
            }
        });
    }
}
