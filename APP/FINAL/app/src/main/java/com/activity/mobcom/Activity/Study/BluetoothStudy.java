package com.activity.mobcom.Activity.Study;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.activity.mobcom.R;

public class BluetoothStudy extends AppCompatActivity {

    private VideoView video_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.study_bluetooth); // Ensure this is the correct layout file

        video_view = findViewById(R.id.video_view);
        ImageView backButton = findViewById(R.id.back);

        backButton.setOnClickListener(view -> finish());

        // Get the video from the raw resources
        Uri videoUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.bluetoothvid);
        video_view.setVideoURI(videoUri);

        // Setup MediaController for video playback controls
        MediaController mediaController = new MediaController(this);
        video_view.setMediaController(mediaController);
        mediaController.setAnchorView(video_view);

        // Start the video
        video_view.start();

        // Handling video errors
        video_view.setOnErrorListener((mp, what, extra) -> {
            Toast.makeText(this, "Error playing video", Toast.LENGTH_SHORT).show();
            return true; // Indicate we handled the error
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        video_view.start(); // Restart video when activity resumes
    }

    @Override
    protected void onPause() {
        super.onPause();
        video_view.pause(); // Pause video when activity is paused
    }
}
