package com.putuwidiarsa.daftardino;

import android.app.ActionBar;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.squareup.picasso.Picasso;

public class DinoDetailActivity extends AppCompatActivity {
    public static final String DINO_NAME = "dino_name";
    public static final String DINO_DESC = "dino_description";
    public static final String DINO_HEIGHT = "dino_height";
    public static final String DINO_WEIGHT = "dino_weight";
    public static final String DINO_FACTS = "dino_facts";
    public static final String DINO_IMG = "dino_image";

/*    private Context context;

    public DinoDetailActivity(Context context){
        this.context = context;
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dino_detail);

        // ================ INI UNTUK MENAMPILKAN TOMBOL KEMBALI DARI INTENT UTAMA / MAIN ACTIVITY ======================
        // ================  DILANJUTKAN DENGAN MEMBUAT CLASS DIBAWAH  ==================================
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView tvDinoName = findViewById(R.id.tv_dino_name);
        TextView tvDinoDesc = findViewById(R.id.tv_dino_desc);
        TextView tvDinoHeight = findViewById(R.id.tv_dino_height);
        TextView tvDinoWeight = findViewById(R.id.tv_dino_weight);
        TextView tvDinoFacts = findViewById(R.id.tv_dino_fact);
        TextView tvFloatingDinoName = findViewById(R.id.floating_dino_name);

        ImageView ivDinoImg = findViewById(R.id.dino_img);

        String name = getIntent().getStringExtra(DINO_NAME);
        String description = getIntent().getStringExtra(DINO_DESC);
        String imagePicture = getIntent().getStringExtra(DINO_IMG);
        String heightD = getIntent().getStringExtra(DINO_HEIGHT);
        String weightD = getIntent().getStringExtra(DINO_WEIGHT);
        String facts = getIntent().getStringExtra(DINO_FACTS);

        tvDinoName.setText(name);
        tvDinoDesc.setText(description);
        tvDinoHeight.setText(heightD);
        tvDinoWeight.setText(weightD);
        tvDinoFacts.setText(facts);
        tvFloatingDinoName.setText(name);


        Glide.with(this)
                .load(imagePicture)
                .apply(new RequestOptions().override(500))
                .into(ivDinoImg);

        setActionBarTitle("Detail " + name);
    }

    private void setActionBarTitle(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }

    // ================ INI UNTUK MENAMPILKAN TOMBOL KEMBALI DARI INTENT UTAMA / MAIN ACTIVITY ======================
    // ================  DILANJUTKAN DENGAN MEMBUAT CLASS DIBAWAH  ==================================
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
}
