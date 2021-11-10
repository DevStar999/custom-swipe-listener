package com.nerdcoredevelopment.customswipelistener.onswipelisteners;

import android.content.Context;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class OnDiagonalSwipeListener implements OnTouchListener {
    private final GestureDetector gestureDetector;

    public OnDiagonalSwipeListener(Context context) {
        gestureDetector = new GestureDetector(context, new GestureListener());
    }

    @Override
    public boolean onTouch(View view, MotionEvent event) {
        view.performClick();
        return gestureDetector.onTouchEvent(event);
    }

    private final class GestureListener extends SimpleOnGestureListener {
        private static final int SWIPE_THRESHOLD = 100;
        private static final int SWIPE_VELOCITY_THRESHOLD = 100;

        @Override
        public boolean onDown(MotionEvent e) {
            return true;
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            boolean result = false;
            try {
                float diffY = e2.getY() - e1.getY();
                float diffX = e2.getX() - e1.getX();
                if (Math.abs(diffX) != 0 || Math.abs(diffY) != 0) {
                    // So only leaving out the case where there is no movement at all
                    if ((Math.abs(diffX) >= SWIPE_THRESHOLD && Math.abs(diffY) >= SWIPE_THRESHOLD)
                            && (Math.abs(velocityX) >= SWIPE_VELOCITY_THRESHOLD
                            || Math.abs(velocityY) >= SWIPE_VELOCITY_THRESHOLD)) {
                        if (diffX >= 0 && diffY >= 0) { // Right Down
                            onSwipeRightDown();
                        } else if (diffX >= 0 && diffY < 0) { // Right Up
                            onSwipeRightUp();
                        } else if (diffX < 0 && diffY >= 0) { // Left Down
                            onSwipeLeftDown();
                        } else if (diffX < 0 && diffY < 0) { // Left Up
                            onSwipeLeftUp();
                        }
                        result = true;
                    }
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            return result;
        }
    }

    public void onSwipeRightDown() {
    }

    public void onSwipeRightUp() {
    }

    public void onSwipeLeftDown() {
    }

    public void onSwipeLeftUp() {
    }
}