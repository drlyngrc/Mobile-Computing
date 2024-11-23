package com.activity.mobcom.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.activity.mobcom.Activity.Activities.LoginActivity;
import com.activity.mobcom.R;

public class Intro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.intro);
        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.mail_layout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });*/

        Button startBtn = findViewById(R.id.start_btn);
        startBtn.setOnClickListener(v -> startActivity(new Intent(Intro.this, LoginActivity.class)));
    }
}