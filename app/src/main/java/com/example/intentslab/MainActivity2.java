package com.example.intentslab;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView tvName = findViewById(R.id.tvName);
        String name = getIntent().getStringExtra("name");
        tvName.setText("Привет, " + name);
    }

    public void back(View view) {
        DatePicker datePicker = findViewById(R.id.datePicker);
        String etDay = String.valueOf(datePicker.getDayOfMonth());
        String etMonth = String.valueOf(datePicker.getMonth() + 1);
        String etYear = String.valueOf(datePicker.getYear());

        Intent intent = new Intent();
        intent.putExtra("day", etDay);
        intent.putExtra("month", etMonth);
        intent.putExtra("year", etYear);

        setResult(RESULT_OK, intent);
        finish();
    }
}
