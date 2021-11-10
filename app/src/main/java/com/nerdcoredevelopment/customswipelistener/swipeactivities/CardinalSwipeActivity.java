package com.nerdcoredevelopment.customswipelistener.swipeactivities;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.nerdcoredevelopment.customswipelistener.onswipelisteners.OnCardinalSwipeListener;
import com.nerdcoredevelopment.customswipelistener.R;

public class CardinalSwipeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardinal_swipe);

        ViewGroup rootLayout = findViewById(R.id.cardinal_root_layout);
        rootLayout.setOnTouchListener(new OnCardinalSwipeListener(this) {
            public void onSwipeLeftToRight() {
                Toast.makeText(CardinalSwipeActivity.this, "Cardinal -> Left to Right",
                        Toast.LENGTH_SHORT).show();
            }

            public void onSwipeRightToLeft() {
                Toast.makeText(CardinalSwipeActivity.this, "Cardinal -> Right to Left",
                        Toast.LENGTH_SHORT).show();
            }

            public void onSwipeTopToBottom() {
                Toast.makeText(CardinalSwipeActivity.this, "Cardinal -> Top to Bottom",
                        Toast.LENGTH_SHORT).show();
            }

            public void onSwipeBottomToTop() {
                Toast.makeText(CardinalSwipeActivity.this, "Cardinal -> Bottom to Top",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}