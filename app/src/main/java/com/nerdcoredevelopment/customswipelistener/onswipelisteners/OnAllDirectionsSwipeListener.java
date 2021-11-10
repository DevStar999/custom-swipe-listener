package com.nerdcoredevelopment.customswipelistener.onswipelisteners;

import android.content.Context;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class OnAllDirectionsSwipeListener implements OnTouchListener {
    private final GestureDetector gestureDetector;

    public OnAllDirectionsSwipeListener(Context context) {
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
                    boolean legitHorizontalSwipe = Math.abs(diffX) >= SWIPE_THRESHOLD && Math.abs(velocityX) >= SWIPE_VELOCITY_THRESHOLD;
                    boolean legitVerticalSwipe = Math.abs(diffY) >= SWIPE_THRESHOLD && Math.abs(velocityY) >= SWIPE_VELOCITY_THRESHOLD;
                    boolean legitDiagonalSwipe = (Math.abs(diffX) >= SWIPE_THRESHOLD && Math.abs(diffY) >= SWIPE_THRESHOLD)
                            && (Math.abs(velocityX) >= SWIPE_VELOCITY_THRESHOLD
                            || Math.abs(velocityY) >= SWIPE_VELOCITY_THRESHOLD);
                    if (Math.abs(diffY) == 0) { // User could have made a very accurate horizontal swipe
                        if (legitHorizontalSwipe) {
                            if (diffX > 0) onSwipeLeftToRight();
                            else onSwipeRightToLeft();
                            result = true;
                        }
                    } else if (Math.abs(diffX) == 0) { // User could have made a very accurate vertical swipe
                        if (legitVerticalSwipe) {
                            if (diffY > 0) onSwipeTopToBottom();
                            else onSwipeBottomToTop();
                            result = true;
                        }
                    } else { // User made a bit inaccurate swipe
                        if (Math.abs(diffX) == Math.abs(diffY)) { // User made an accurate diagonal swipe
                            if (legitDiagonalSwipe) {
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
                        } else { // Un-even diffX and diffY values
                            if (Math.abs(diffX) > Math.abs(diffY)) {
                                if (Math.abs(diffY) > Math.abs(diffX/2)) { // Diagonal Swipe
                                    if (legitDiagonalSwipe) {
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
                                } else { // Cardinal Swipe
                                    if (legitHorizontalSwipe) {
                                        if (diffX > 0) onSwipeLeftToRight();
                                        else onSwipeRightToLeft();
                                        result = true;
                                    }
                                }
                            } else if (Math.abs(diffX) < Math.abs(diffY)) {
                                if (Math.abs(diffX) > Math.abs(diffY/2)) { // Diagonal Swipe
                                    if (legitDiagonalSwipe) {
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
                                } else { // Cardinal Swipe
                                    if (legitVerticalSwipe) {
                                        if (diffY > 0) onSwipeTopToBottom();
                                        else onSwipeBottomToTop();
                                        result = true;
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            return result;
        }
    }

    public void onSwipeLeftToRight() {
    }

    public void onSwipeRightToLeft() {
    }

    public void onSwipeTopToBottom() {
    }

    public void onSwipeBottomToTop() {
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