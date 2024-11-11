package com.activity.mobcom.Navigation;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.activity.mobcom.Activity.Activities.ListActivity;
import com.activity.mobcom.Activity.Flag.ShowFlag;
import com.activity.mobcom.Activity.Study.InfraredStudy;
import com.activity.mobcom.Activity.Study.ListStudy;
import com.activity.mobcom.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class Main extends AppCompatActivity {

    FirebaseAuth auth;
    FirebaseUser user;
    TextView user_details, see_all;
    Button logout;

    ConstraintLayout actBtn, studyBtn, infraredBtn, flagBtn, exploreBtn;
    ImageView home, otherbtn, profile, setting;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.main);


        auth = FirebaseAuth.getInstance();
        //user_details = findViewById(R.id.user_details);
        user = auth.getCurrentUser();
        //logout = findViewById(R.id.logout_button);

        actBtn = findViewById(R.id.act_btn);
        studyBtn = findViewById(R.id.study_btn);
        infraredBtn = findViewById(R.id.infrared_btn);
        flagBtn = findViewById(R.id.flag_btn);
        exploreBtn = findViewById(R.id.explore_btn);
        see_all = findViewById(R.id.see_all);
        home = findViewById(R.id.home);
        otherbtn = findViewById(R.id.otherbtn);
        profile = findViewById(R.id.profile);
        setting = findViewById(R.id.setting);

        setActiveButton(home);

        actBtn.setOnClickListener(v -> startActivity(new Intent(Main.this, ListActivity.class)));
        studyBtn.setOnClickListener(v -> startActivity(new Intent(Main.this, ListStudy.class)));
        infraredBtn.setOnClickListener(v -> startActivity(new Intent(Main.this, InfraredStudy.class)));
        flagBtn.setOnClickListener(v -> startActivity(new Intent(Main.this, ShowFlag.class)));
        //exploreBtn.setOnClickListener(v -> startActivity(new Intent(Main.this, ListExplore.class)));
        see_all.setOnClickListener(v -> startActivity(new Intent(Main.this, ListStudy.class)));

        otherbtn.setOnClickListener(v -> {
            Log.d("MainActivity", "Other button clicked");
            setActiveButton(otherbtn);
            startActivity(new Intent(Main.this, ListActivity.class));
        });
        profile.setOnClickListener(v -> {
            Log.d("MainActivity", "Profile button clicked");
            setActiveButton(profile);
            startActivity(new Intent(Main.this, Profile.class));
        });
        setting.setOnClickListener(v -> {
            Log.d("MainActivity", "Home button clicked");
            setActiveButton(setting);
            startActivity(new Intent(Main.this, Setting.class));
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