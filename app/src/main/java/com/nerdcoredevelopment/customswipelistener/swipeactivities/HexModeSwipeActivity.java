package com.nerdcoredevelopment.customswipelistener.swipeactivities;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.nerdcoredevelopment.customswipelistener.R;
import com.nerdcoredevelopment.customswipelistener.onswipelisteners.OnHexModeSwipeListener;

// This special swipe listener is for the 2048 game's hex mode
public class HexModeSwipeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hex_mode_swipe);

        ViewGroup rootLayout = findViewById(R.id.hex_mode_root_layout);
        rootLayout.setOnTouchListener(new OnHexModeSwipeListener(this) {
            public void onSwipeLeftToRight() {
                Toast.makeText(HexModeSwipeActivity.this, "Hex Mode -> Left to Right",
                        Toast.LENGTH_SHORT).show();
            }

            public void onSwipeRightToLeft() {
                Toast.makeText(HexModeSwipeActivity.this, "Hex Mode -> Right to Left",
                        Toast.LENGTH_SHORT).show();
            }

            public void onSwipeRightDown() {
                Toast.makeText(HexModeSwipeActivity.this, "Hex Mode -> Right Down",
                        Toast.LENGTH_SHORT).show();
            }

            public void onSwipeRightUp() {
                Toast.makeText(HexModeSwipeActivity.this, "Hex Mode -> Right Up",
                        Toast.LENGTH_SHORT).show();
            }

            public void onSwipeLeftDown() {
                Toast.makeText(HexModeSwipeActivity.this, "Hex Mode -> Left Down",
                        Toast.LENGTH_SHORT).show();
            }

            public void onSwipeLeftUp() {
                Toast.makeText(HexModeSwipeActivity.this, "Hex Mode -> Left Up",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}