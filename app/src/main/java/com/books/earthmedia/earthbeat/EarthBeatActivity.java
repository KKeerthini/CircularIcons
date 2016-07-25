package com.books.earthmedia.earthbeat;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

public class EarthBeatActivity extends Activity {

    ImageView imgView3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
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
