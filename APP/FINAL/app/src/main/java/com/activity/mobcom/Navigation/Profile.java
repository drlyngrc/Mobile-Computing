package com.activity.mobcom.Navigation;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.activity.mobcom.Activity.Activities.ListActivity;
import com.activity.mobcom.Activity.Activities.LoginActivity;
import com.activity.mobcom.R;

public class Profile extends AppCompatActivity {

    ConstraintLayout actBtn, studyBtn;
    ImageView home, profile, profileImageView;
    TextView nameView, usernameView, emailView;
    Button logoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);

        home = findViewById(R.id.home);
        profile = findViewById(R.id.profile);
        nameView = findViewById(R.id.user_name);
        usernameView = findViewById(R.id.user_username);
        emailView = findViewById(R.id.user_email);
        profileImageView = findViewById(R.id.user_image);
        logoutButton = findViewById(R.id.logout_button);

        // Fetch user details from SharedPreferences or Intent
        SharedPreferences sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE);
        nameView.setText(sharedPreferences.getString("userName", "Guest User"));
        usernameView.setText("Username: " + sharedPreferences.getString("userUsername", "guest"));
        emailView.setText("Email: " + sharedPreferences.getString("userEmail", "guest@example.com"));

        setActiveButton(profile);

        // Handle navigation
        home.setOnClickListener(v -> {
            Log.d("MainActivity", "Home button clicked");
            setActiveButton(home);
            startActivity(new Intent(Profile.this, Main.class));
        });

        // Logout
        logoutButton.setOnClickListener(v -> {
            // Clear user session or preferences
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.clear(); // Clear all stored user data
            editor.apply();

            // Navigate to login screen
            Intent intent = new Intent(Profile.this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK); // Clear backstack
            startActivity(intent);
            Toast.makeText(Profile.this, "Logged out successfully", Toast.LENGTH_SHORT).show();
        });
    }

    private void setActiveButton(ImageView selectedButton) {
        Log.d("MainActivity", "setActiveButton: " + selectedButton.getId());

        // Deselect all buttons first
        home.setSelected(false);
        if (profile != null) {
            profile.setSelected(false);
        }

        // Set only the clicked button as selected
        selectedButton.setSelected(true);
        selectedButton.invalidate(); // Force UI refresh
    }


}
