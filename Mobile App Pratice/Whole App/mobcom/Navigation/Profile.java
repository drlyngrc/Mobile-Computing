package com.activity.mobcom.Navigation;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.activity.mobcom.Activity.Activities.ListActivity;
import com.activity.mobcom.R;

public class Profile extends AppCompatActivity {

    ConstraintLayout actBtn, studyBtn;
    ImageView home, otherbtn, profile, setting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);

        home = findViewById(R.id.home);
        otherbtn = findViewById(R.id.otherbtn);
        profile = findViewById(R.id.profile);
        setting = findViewById(R.id.setting);

        setActiveButton(profile);

        home.setOnClickListener(v -> {
            Log.d("MainActivity", "Home button clicked");
            setActiveButton(home);
            startActivity(new Intent(Profile.this, Main.class));
        });
        otherbtn.setOnClickListener(v -> {
            Log.d("MainActivity", "Other button clicked");
            setActiveButton(otherbtn);
            startActivity(new Intent(Profile.this, ListActivity.class));
        });
        setting.setOnClickListener(v -> {
            Log.d("MainActivity", "Home button clicked");
            setActiveButton(setting);
            startActivity(new Intent(Profile.this, Setting.class));
        });
    }

    private void setActiveButton(ImageView selectedButton) {
        Log.d("MainActivity", "setActiveButton: " + selectedButton.getId());

        // Deselect all buttons first
        home.setSelected(false);
        if (otherbtn != null) {
            otherbtn.setSelected(false);
        }

        // Set only the clicked button as selected
        selectedButton.setSelected(true);
        selectedButton.invalidate(); // Force UI refresh
    }
}
