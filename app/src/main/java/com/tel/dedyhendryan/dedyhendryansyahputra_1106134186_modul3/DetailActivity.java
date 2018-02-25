package com.tel.dedyhendryan.dedyhendryansyahputra_1106134186_modul3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {
    private ImageView level;
    private TextView levelIndicator;
    private int minLevel = 2;
    private int currentLevel = 1;
    private int maxLevel = 5;
    private String txtIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        TextView title = (TextView) findViewById(R.id.titleDetail);
        levelIndicator = (TextView) findViewById(R.id.drinkIndicator);
        String iTitle = intent.getStringExtra("title");

        title.setText(iTitle);

        level = (ImageView) findViewById(R.id.drinkLevel);

        Log.d("level ", "level: "+txtIndicator);

    }

    //method utk dapat menambahkan level terhadap icon botol
    public void addLevel(View view) {
        //jika di klik pada level akan naik 1 level
        currentLevel+=0;

        //if statement untuk pengecekkan agar level tidak melebihi maksimum level
        if (currentLevel<=maxLevel){
            level.setImageLevel(currentLevel+=1);
            levelIndicator.setText(currentLevel+"L");

            //if statement untuk menampilkan toast yang berisi pesan kalau air sudah penuh
            if (currentLevel==6){
                Toast.makeText(this, "Air Sudah Penuh", Toast.LENGTH_SHORT).show();
            }
            Log.d("current level", "Current Level: "+currentLevel);

            //else untuk menjaga agar level tidak melebihi maksimum level
        }else{
            currentLevel=maxLevel;
            txtIndicator=currentLevel+"L";
        }


    }
    //method utk mengurangi level terhadap icon botol
    public void decreaseLevel(View view) {
        //jika di klik maka level berkurang 1 level
        currentLevel-=0;
        //if statement untuk pengecekan apakah level kurang dari minimum level
        if (currentLevel>=minLevel){
            level.setImageLevel(currentLevel-=1);
            levelIndicator.setText(currentLevel+"L");

            //menampilkan toast jika level sama dengan minimum level
            if  (currentLevel==1){
                Toast.makeText(this, "Air sedikit", Toast.LENGTH_SHORT).show();
            }
            //else untuk menjaga agar level tidak kurang dari minimum level
        }else{
            currentLevel=minLevel;
            txtIndicator=currentLevel+"L";;
        }
    }
}