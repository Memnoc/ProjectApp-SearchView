package com.smartdroidesign.searchview.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;

import com.smartdroidesign.searchview.R;
import com.smartdroidesign.searchview.model.Name;
import com.smartdroidesign.searchview.presenter.Adapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Name> nameList = new ArrayList<>();
    private Adapter animalsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SearchView searchView = findViewById(R.id.search_view);
        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        addNameToList("Giraffe");
        addNameToList("Tiger");
        addNameToList("Rhinoceros");
        addNameToList("Cat");
        addNameToList("Dog");
        addNameToList("Bird");
        addNameToList("Lion");
        addNameToList("Elephant");
        addNameToList("Bear");
        addNameToList("Cattle");
        addNameToList("Wolf");
        addNameToList("Rabbit");
        addNameToList("Snakes");
        addNameToList("Whales");
        addNameToList("Monkey");

        animalsAdapter = new Adapter(this, nameList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(animalsAdapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String queryString) {
                animalsAdapter.getFilter().filter(queryString);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String queryString) {
                animalsAdapter.getFilter().filter(queryString);
                return false;
            }
        });
    }

    private void addNameToList(String name) {
        nameList.add(new Name(name));
    }
}
