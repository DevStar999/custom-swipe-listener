package com.nerdcoredevelopment.customswipelistener.swipeactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Toast;

import com.nerdcoredevelopment.customswipelistener.R;
import com.nerdcoredevelopment.customswipelistener.onswipelisteners.OnDiagonalSwipeListener;

public class DiagonalSwipeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagonal_swipe);

        ViewGroup rootLayout = findViewById(R.id.diagonal_root_layout);
        rootLayout.setOnTouchListener(new OnDiagonalSwipeListener(this) {
            public void onSwipeRightDown() {
                Toast.makeText(DiagonalSwipeActivity.this, "Diagonal -> Right Down",
                        Toast.LENGTH_SHORT).show();
            }

            public void onSwipeRightUp() {
                Toast.makeText(DiagonalSwipeActivity.this, "Diagonal -> Right Up",
                        Toast.LENGTH_SHORT).show();
            }

            public void onSwipeLeftDown() {
                Toast.makeText(DiagonalSwipeActivity.this, "Diagonal -> Left Down",
                        Toast.LENGTH_SHORT).show();
            }

            public void onSwipeLeftUp() {
                Toast.makeText(DiagonalSwipeActivity.this, "Diagonal -> Left Up",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}