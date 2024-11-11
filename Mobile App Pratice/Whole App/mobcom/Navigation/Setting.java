package com.activity.mobcom.Navigation;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.activity.mobcom.Activity.Activities.ListActivity;
import com.activity.mobcom.R;

public class Setting extends AppCompatActivity {

    ImageView home, otherbtn, profile, setting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting);

        home = findViewById(R.id.home);
        otherbtn = findViewById(R.id.otherbtn);
        profile = findViewById(R.id.profile);
        setting = findViewById(R.id.setting);

        setActiveButton(setting);

        home.setOnClickListener(v -> {
            Log.d("MainActivity", "Home button clicked");
            setActiveButton(home);
            startActivity(new Intent(Setting.this, Main.class));
        });
        otherbtn.setOnClickListener(v -> {
            Log.d("MainActivity", "Other button clicked");
            setActiveButton(otherbtn);
            startActivity(new Intent(Setting.this, ListActivity.class));
        });
        profile.setOnClickListener(v -> {
            Log.d("MainActivity", "Profile button clicked");
            setActiveButton(profile);
            startActivity(new Intent(Setting.this, Profile.class));
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
