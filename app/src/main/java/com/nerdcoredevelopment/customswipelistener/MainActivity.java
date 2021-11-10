package com.nerdcoredevelopment.customswipelistener;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.nerdcoredevelopment.customswipelistener.swipeactivities.AllDirectionsSwipeActivity;
import com.nerdcoredevelopment.customswipelistener.swipeactivities.CardinalSwipeActivity;
import com.nerdcoredevelopment.customswipelistener.swipeactivities.DiagonalSwipeActivity;
import com.nerdcoredevelopment.customswipelistener.swipeactivities.HexModeSwipeActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void gotoCardinalSwipeLayout(View view) {
        Intent intent = new Intent(MainActivity.this, CardinalSwipeActivity.class);
        startActivity(intent);
    }

    public void gotoDiagonalSwipeLayout(View view) {
        Intent intent = new Intent(MainActivity.this, DiagonalSwipeActivity.class);
        startActivity(intent);
    }

    public void gotoCardinalAndDiagonalSwipeLayout(View view) {
        Intent intent = new Intent(MainActivity.this, AllDirectionsSwipeActivity.class);
        startActivity(intent);
    }

    public void gotoHexModeSwipeLayout(View view) {
        Intent intent = new Intent(MainActivity.this, HexModeSwipeActivity.class);
        startActivity(intent);
    }
}