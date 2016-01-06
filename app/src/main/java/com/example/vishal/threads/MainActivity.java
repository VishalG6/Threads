package com.example.vishal.threads;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
    }

    public void clickVishButton(View view) {
        long futureTime = System.currentTimeMillis() + 10000;
        while (System.currentTimeMillis() < futureTime) {
            synchronized (this) {
                try {
                    wait(futureTime - System.currentTimeMillis());
                } catch (Exception e) {
                }
            }
        }
        TextView vishText = (TextView) findViewById(R.id.vishText);
        vishText.setText("Good Job!");

    }
}