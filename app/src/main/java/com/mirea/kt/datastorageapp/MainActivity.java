package com.mirea.kt.datastorageapp;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private PlantDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new PlantDatabaseHelper(this);

        EditText nameEditText = findViewById(R.id.nameEditText);
        EditText varietyEditText = findViewById(R.id.varietyEditText);
        Switch greenhouseSwitch = findViewById(R.id.greenhouseSwitch);
        Button saveButton = findViewById(R.id.saveButton);
        Button viewButton = findViewById(R.id.viewButton);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString().trim();
                String variety = varietyEditText.getText().toString().trim();
                boolean isGreenhousePlant = greenhouseSwitch.isChecked();

                if (!name.isEmpty() && !variety.isEmpty()) {
                    savePlant(name, variety, isGreenhousePlant);
                }
            }
        });

        viewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PlantListActivity.class);
                startActivity(intent);
            }
        });
    }

    private void savePlant(String name, String variety, boolean isGreenhousePlant) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("variety", variety);
        values.put("isGreenhousePlant", isGreenhousePlant ? 1 : 0);

        db.insert("plants", null, values);
    }
}