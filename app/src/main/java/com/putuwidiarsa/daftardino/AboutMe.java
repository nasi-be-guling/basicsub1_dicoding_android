package com.putuwidiarsa.daftardino;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class AboutMe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_me);

        // ================ INI UNTUK MENAMPILKAN TOMBOL KEMBALI DARI INTENT UTAMA / MAIN ACTIVITY ======================
        // ================  DILANJUTKAN DENGAN MEMBUAT CLASS DIBAWAH  ==================================
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setActionBarTitle("About Me");
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
