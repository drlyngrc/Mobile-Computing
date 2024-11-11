package com.activity.mobcom.Activity.Study;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.activity.mobcom.Navigation.Main;
import com.activity.mobcom.Adapter.StudiesAdapter;
import com.activity.mobcom.Domain.StudiesDomain;
import com.activity.mobcom.R;

import java.util.ArrayList;

public class ListStudy extends AppCompatActivity {

    private RecyclerView.Adapter adapterList;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.list_study);
        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });*/

        initRecyclerView();
    }

    private void initRecyclerView() {
        ArrayList<StudiesDomain> items = new ArrayList<>();
        items.add(new StudiesDomain("Infrared Communication","infrared"));
        items.add(new StudiesDomain("Bluetooth File Transfer in Android ","bluetooth"));
        items.add(new StudiesDomain("Bluetooth Device in Wireless Range","wireless"));

        recyclerView = findViewById(R.id.view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        adapterList = new StudiesAdapter(items);
        recyclerView.setAdapter(adapterList);

        ImageView back = findViewById(R.id.back);
        back.setOnClickListener(v -> finish());
    }
}