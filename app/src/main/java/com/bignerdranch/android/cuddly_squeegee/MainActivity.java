package com.bignerdranch.android.cuddly_squeegee;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends Activity {

    private Button mTopLeft;
    private Button mTopMid;
    private Button mTopRight;
    private Button mMidLeft;
    private Button mMiddle;
    private Button mMidRight;
    private Button mBottomLeft;
    private Button mBottomMid;
    private Button mBottomRight;

    private Button mButtons[]={mTopLeft, mTopMid, mTopRight,
                               mMidLeft, mMiddle, mMidRight,
                               mBottomLeft, mBottomMid, mBottomRight};


    private Button mTimeField;
    private TextView mScoreField;
    private Button mScoreBoard;
    private int num;

    private int score=0; //keeps track of how many correct button pushes
    private CountDownTimer countDown;
    private long startTime=60000;
    private boolean correctPush;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        mTimeField=(Button) findViewById(R.id.time_field);
        mTimeField.setEnabled(false);
        countDown= new GameCountDownTimer(60000,1000);
        mTimeField.setText(String.valueOf(startTime/1000));

        countDown.start();


        boolean pushed; //whether you pushed the button or not






        mScoreField=(TextView) findViewById(R.id.score_text);
        mScoreBoard=(Button) findViewById(R.id.score_field);
        mScoreBoard.setEnabled(false);






            mTopLeft = (Button) findViewById(R.id.top_left);
            mTopLeft.setBackgroundColor(Color.parseColor("#0DB0B8"));
            mButtons[0]=mTopLeft;
            mTopLeft.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    checkPush(0,mTopLeft);

                }
            });

            mTopMid = (Button) findViewById(R.id.top_mid);
            mTopMid.setBackgroundColor(Color.parseColor("#0DB0B8"));
            mButtons[1]=mTopMid;
            mTopMid.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    checkPush(1,mTopMid);

                }
            });

            mTopRight = (Button) findViewById(R.id.top_right);
            mTopRight.setBackgroundColor(Color.parseColor("#0DB0B8"));
            mButtons[2]=mTopRight;
            mTopRight.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    checkPush(2,mTopRight);

                }
            });

            mMidLeft = (Button) findViewById(R.id.mid_left);
            mMidLeft.setBackgroundColor(Color.parseColor("#0DB0B8"));
            mButtons[3]=mMidLeft;
            mMidLeft.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    checkPush(3,mMidLeft);

                }
            });

            mMiddle = (Button) findViewById(R.id.middle);
            mMiddle.setBackgroundColor(Color.parseColor("#0DB0B8"));
            mButtons[4]=mMiddle;
            mMiddle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    checkPush(4,mMiddle);

                }
            });

            mMidRight = (Button) findViewById(R.id.mid_right);
            mMidRight.setBackgroundColor(Color.parseColor("#0DB0B8"));
            mButtons[5]=mMidRight;
            mMidRight.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    checkPush(5,mMidRight);

                }
            });

            mBottomLeft = (Button) findViewById(R.id.bottom_left);
            mBottomLeft.setBackgroundColor(Color.parseColor("#0DB0B8"));
            mButtons[6]=mBottomLeft;
            mBottomLeft.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    checkPush(6,mBottomLeft);

                }
            });

            mBottomMid = (Button) findViewById(R.id.bottom_mid);
            mBottomMid.setBackgroundColor(Color.parseColor("#0DB0B8"));
            mButtons[7]=mBottomMid;
            mBottomMid.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    checkPush(7,mBottomMid);

                }
            });

            mBottomRight = (Button) findViewById(R.id.bottom_right);
            mBottomRight.setBackgroundColor(Color.parseColor("#0DB0B8"));
            mButtons[8]=mBottomRight;
            mBottomRight.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    checkPush(8, mBottomRight);

                }
            });

        chooseButton();

        }


    private void chooseButton() {
        num=0+(int)(Math.random()*8);

        mButtons[num].setBackgroundColor(Color.parseColor("#FF0000"));

    }

    public class GameCountDownTimer extends CountDownTimer{
        public GameCountDownTimer (long startTime, long interval){
            super(startTime, interval);
        }

        @Override
        public void onFinish(){
            mTimeField.setText("--");

            Intent i= EndScreen.newIntent(MainActivity.this, score );
            startActivityForResult(i,0);

            mTopRight.setEnabled(false);
            mTopMid.setEnabled(false);
            mTopLeft.setEnabled(false);
            mMidRight.setEnabled(false);
            mMiddle.setEnabled(false);
            mMidLeft.setEnabled(false);
            mBottomRight.setEnabled(false);
            mBottomMid.setEnabled(false);
            mBottomLeft.setEnabled(false);


        }

        @Override
        public void onTick(long millisUntilFinished){
            mTimeField.setText(""+ millisUntilFinished/1000);
        }
    }

    private void checkPush(int choosen, Button b) {


        if (choosen!=num) {
            correctPush=false;
        }
        else {
            correctPush=true;
            b.setBackgroundColor(Color.parseColor("#0DB0B8"));
            chooseButton();
        }

        updateScore(correctPush);
    }

    private void updateScore(boolean push) {
        if (push==true) {
            score += 1;
            String scoreText=Integer.toString(score);
            mScoreBoard.setText(scoreText);
        }

    }






}
