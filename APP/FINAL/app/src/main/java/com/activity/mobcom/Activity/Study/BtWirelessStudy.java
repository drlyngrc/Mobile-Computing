package com.activity.mobcom.Activity.Study;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.activity.mobcom.R;

public class BtWirelessStudy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.study_btwireless);

        ImageView backButton = findViewById(R.id.back);
        backButton.setOnClickListener(view -> finish());
    }
}
