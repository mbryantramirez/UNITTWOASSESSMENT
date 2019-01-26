package org.pursuit.unit_02_assessment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
private TextView secondTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        secondTextView = findViewById(R.id.secondTextView);

        Intent intent = getIntent();
        String result = intent.getStringExtra("result");
        secondTextView.setText(result);
    }
}
