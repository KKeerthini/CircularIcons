package com.books.earthmedia.earthbeat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class EarthBeatActivity extends AppCompatActivity {

    ImageView imgView3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainicons);
        imgView3=(ImageView)findViewById(R.id.subj3);
        imgView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(EarthBeatActivity.this,EarthBeatFlashCard.class);
                startActivity(intent);
            }
        });
    }
}
