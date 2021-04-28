package com.aca.coctailappmvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.aca.coctailappmvvm.adapters.RecyclerAdapterCoctailList;
import com.aca.coctailappmvvm.models.Coctail;

import java.util.List;

public class SearchListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_list);

        RecyclerView recyclerView;


        recyclerView = findViewById(R.id.recyclerView);

        List<Coctail> list;
        list = getIntent().getExtras().getParcelableArrayList("coctailList");
        Log.d("myTag", "onCreate: "+list.get(0));


        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        RecyclerAdapterCoctailList adapter = new RecyclerAdapterCoctailList(list);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}