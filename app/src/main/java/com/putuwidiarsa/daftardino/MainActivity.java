package com.putuwidiarsa.daftardino;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvDino;
    private ArrayList<Dino> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvDino = findViewById(R.id.rv_dino);
        rvDino.setHasFixedSize(true);
        list.addAll(DinoData.getListData());

        setActionBarTitle("DAFTAR 10 DINOSAURUS");
        showRecyclerList();
    }

    private void showRecyclerGrid(){
        rvDino.setLayoutManager(new GridLayoutManager(this, 2));
        GridDinoAdapter gridDinoAdapter = new GridDinoAdapter(list);
        rvDino.setAdapter(gridDinoAdapter);
    }

    private void showRecyclerList(){
        rvDino.setLayoutManager(new LinearLayoutManager(this));
        ListDinoAdapter listDinoAdapter = new ListDinoAdapter(list);
        rvDino.setAdapter(listDinoAdapter);
    }

    private void setActionBarTitle(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // insert code about me here
        Intent aboutMe = new Intent(MainActivity.this, AboutMe.class);
        startActivity(aboutMe);
        return super.onOptionsItemSelected(item);
    }
}
