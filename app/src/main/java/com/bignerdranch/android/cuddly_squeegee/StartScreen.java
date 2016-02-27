package com.bignerdranch.android.cuddly_squeegee;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class StartScreen extends Activity {

    private Button mStartButton;
    private TextView mPlayText;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.start_screen);

        mPlayText=(TextView) findViewById(R.id.textView);

        mStartButton=(Button) findViewById(R.id.button);

        mStartButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
               Intent i= new Intent(StartScreen.this, MainActivity.class);
            startActivity(i);
            }
        });
    }
}
