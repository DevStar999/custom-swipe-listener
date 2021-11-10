package com.nerdcoredevelopment.customswipelistener.swipeactivities;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.nerdcoredevelopment.customswipelistener.R;
import com.nerdcoredevelopment.customswipelistener.onswipelisteners.OnAllDirectionsSwipeListener;

public class AllDirectionsSwipeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_directions_swipe);

        ViewGroup rootLayout = findViewById(R.id.all_directions_root_layout);
        rootLayout.setOnTouchListener(new OnAllDirectionsSwipeListener(this) {
            public void onSwipeLeftToRight() {
                Toast.makeText(AllDirectionsSwipeActivity.this, "AllDirections -> Left to Right",
                        Toast.LENGTH_SHORT).show();
            }

            public void onSwipeRightToLeft() {
                Toast.makeText(AllDirectionsSwipeActivity.this, "AllDirections -> Right to Left",
                        Toast.LENGTH_SHORT).show();
            }

            public void onSwipeTopToBottom() {
                Toast.makeText(AllDirectionsSwipeActivity.this, "AllDirections -> Top to Bottom",
                        Toast.LENGTH_SHORT).show();
            }

            public void onSwipeBottomToTop() {
                Toast.makeText(AllDirectionsSwipeActivity.this, "AllDirections -> Bottom to Top",
                        Toast.LENGTH_SHORT).show();
            }
            
            public void onSwipeRightDown() {
                Toast.makeText(AllDirectionsSwipeActivity.this, "AllDirections -> Right Down",
                        Toast.LENGTH_SHORT).show();
            }

            public void onSwipeRightUp() {
                Toast.makeText(AllDirectionsSwipeActivity.this, "AllDirections -> Right Up",
                        Toast.LENGTH_SHORT).show();
            }

            public void onSwipeLeftDown() {
                Toast.makeText(AllDirectionsSwipeActivity.this, "AllDirections -> Left Down",
                        Toast.LENGTH_SHORT).show();
            }

            public void onSwipeLeftUp() {
                Toast.makeText(AllDirectionsSwipeActivity.this, "AllDirections -> Left Up",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}