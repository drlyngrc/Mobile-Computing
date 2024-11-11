package com.activity.mobcom.Activity.Study;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.activity.mobcom.R;

public class InfraredStudy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.study_infrared);

        ImageView backButton = findViewById(R.id.back);
        backButton.setOnClickListener(view -> finish());

    }


}
