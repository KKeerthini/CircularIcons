package com.books.earthmedia.earthbeat;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by KEERTHINI on 7/25/2016.
 */


public class EarthBeatFlashCard extends Activity implements SimpleGestureFilter.SimpleGestureListener {
    private SimpleGestureFilter detector;
    private TextView questionTextView, answerTextView;
    LinearLayout answerLayout;
    private int i = 0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_flashcard);
        questionTextView = (TextView) findViewById(R.id.questions);
        answerTextView = (TextView) findViewById(R.id.answer);
        answerLayout = (LinearLayout) findViewById(R.id.answerLayout);
        questionTextView.setText(DataArray.questions[i]);
        // Detect touched area
        detector = new SimpleGestureFilter(this, this);

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent me) {
        // Call onTouchEvent of SimpleGestureFilter class
        this.detector.onTouchEvent(me);
        return super.dispatchTouchEvent(me);
    }

    @Override
    public void onSwipe(int direction) {
        String str = "";

        switch (direction) {

            case SimpleGestureFilter.SWIPE_RIGHT:
                str = "Swipe Right";

                break;
            case SimpleGestureFilter.SWIPE_LEFT:
                str = "Swipe Left";
                if (i < DataArray.questions.length - 1) {


                    i++;
                    questionTextView.setText(DataArray.questions[i]);

                    answerTextView.setVisibility(View.INVISIBLE);
                } else {
                    Toast.makeText(getApplicationContext(), "qUESTIONS Over", Toast.LENGTH_SHORT).show();
                }
                break;
            case SimpleGestureFilter.SWIPE_DOWN:
                str = "Swipe Down";
                break;
            case SimpleGestureFilter.SWIPE_UP:
                str = "Swipe Up";
                final Animation slideup = AnimationUtils.loadAnimation(this,R.anim.slide_up);
                //  final Animation trainfade = AnimationUtils.loadAnimation(this,R.anim.slide_down);
                answerTextView.startAnimation(slideup);
                answerTextView.setText(DataArray.answer[i]);
                answerTextView.setVisibility(View.VISIBLE);
                break;

        }
        Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDoubleTap() {
        Toast.makeText(getApplicationContext(), "Double Tap", Toast.LENGTH_SHORT).show();
    }

}
