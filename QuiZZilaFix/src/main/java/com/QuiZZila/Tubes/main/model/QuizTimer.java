package com.QuiZZila.Tubes.main.model;

import java.util.Timer;
import java.util.TimerTask;

public class QuizTimer {
    private int timeLimit;
    private boolean isTimeUp;
    private int remainingTime;


    public QuizTimer(int timeLimit) {
        this.timeLimit = timeLimit;
        this.remainingTime = timeLimit;
        this.isTimeUp = false;
        startTimer();
    }
    public int getRemainingTime() {
        return remainingTime;
    }

    private void startTimer() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                isTimeUp = true;
                timer.cancel();
            }
        }, 0, 1000);

        timer.schedule(new TimerTask() {
            public void run() {
                remainingTime--;
                if (remainingTime <= 0) {
                    isTimeUp = true;
                    timer.cancel();
                }
            }
        }, 1000, 1000);
    }


    public int getTimeLimit() {
        return timeLimit;
    }

    public boolean isTimeUp() {
        return isTimeUp;
    }
}