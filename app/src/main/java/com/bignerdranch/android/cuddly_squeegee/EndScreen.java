package com.bignerdranch.android.cuddly_squeegee;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by skean055 on 12/8/2015.
 */
public class EndScreen extends Activity {

    private Button mRetryButton;

    private TextView mScoreText;
    private int EndScore;
    private static final String EXTRA_SCORE="com.cuddly.android.endscore";

    public static Intent newIntent(Context packageContext, int score ){
        Intent i= new Intent(packageContext, EndScreen.class);
        i.putExtra(EXTRA_SCORE, score);
        return i;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.end_screen);

        mScoreText=(TextView) findViewById(R.id.final_score);

        mRetryButton=(Button) findViewById(R.id.retry_button);

        //SET SCORE FROM MAIN ACTIVITY
        EndScore= getIntent().getIntExtra(EXTRA_SCORE,0);
        String es= Integer.toString(EndScore);
        mScoreText.setText(es);

        mRetryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(EndScreen.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
