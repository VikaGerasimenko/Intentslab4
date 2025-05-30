package com.example.intentslab;

import android.content.Intent;
import android.os.Bundle;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView twDay;
    private ActivityResultLauncher<Intent> activityResultLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        twDay = findViewById(R.id.twDay);
        activityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                        String day = result.getData().getStringExtra("day");
                        String month = result.getData().getStringExtra("month");
                        String year = result.getData().getStringExtra("year");
                        twDay.setText(day + "." + month + "." + year);
                    }
                }
        );
    }
    public void onClick(View v) {
        EditText etName = findViewById(R.id.etName);
        String name = etName.getText().toString();

        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        intent.putExtra("name", name);
        activityResultLauncher.launch(intent);
    }

    public void date(View v) {
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        activityResultLauncher.launch(intent);
    }
}