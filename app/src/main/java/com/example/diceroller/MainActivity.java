package com.example.diceroller;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int counterscore;
    TextView score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        counterscore = 0;
        score = (TextView) findViewById(R.id.score);
        score.setText("Score: " + counterscore);


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
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

    public void on_button_click(View view) {
        try {

            EditText editText = (EditText) findViewById(R.id.editText);
            Log.i("UserInputNumber", editText.getText().toString());
            String numin = (editText.getText().toString());
            int numint = Integer.parseInt(numin);
            if ((numint < 1) || (numint >6)){
                throw new IllegalArgumentException("Please input a value between 1 and 6");
            }


            TextView tv = this.findViewById(R.id.NumberTextView);
            Random r = new Random();
            int number = r.nextInt((6-1) + 1)+1;

                tv.setText(Integer.toString(number));

            check(numint, number);
        } catch (Exception e) {
            Toast.makeText(MainActivity.this, "Please input a value between 1 and 6", Toast.LENGTH_SHORT).show();
        }


    }


        public void check(int a, int b) {

        if (a == b) {
            Toast.makeText(MainActivity.this, "CONGRATULATIONS", Toast.LENGTH_SHORT).show();
            scorecounter();

        } else {
            Toast.makeText(MainActivity.this, "Try again :-(", Toast.LENGTH_SHORT).show();
        }

    }


    public void scorecounter() {
        counterscore++;
        score.setText("Score: " + counterscore);



    }
}