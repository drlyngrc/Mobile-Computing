package com.activity.mobcom.Activity.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.activity.mobcom.Navigation.Main;
import com.activity.mobcom.Adapter.ActivitiesAdapter;
import com.activity.mobcom.Domain.ActivitiesDomain;
import com.activity.mobcom.R;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    private RecyclerView.Adapter adapterList;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.list_activity);
        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });*/

        initRecyclerView();
    }

    private void initRecyclerView() {
        ArrayList<ActivitiesDomain> items = new ArrayList<>();
        items.add(new ActivitiesDomain("Activity #1: Welcome Message","ic_1"));
        items.add(new ActivitiesDomain("Activity #2: Registration Form","ic_2"));
        items.add(new ActivitiesDomain("Activity #3: Login and Sign Up Page","ic_3"));
        items.add(new ActivitiesDomain("Activity #4: Calculator","ic_4"));


        recyclerView = findViewById(R.id.view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        adapterList = new ActivitiesAdapter(items);
        recyclerView.setAdapter(adapterList);

        ImageView back = findViewById(R.id.back);
        back.setOnClickListener(v -> finish());
    }
}