package com.mirea.kt.datastorageapp;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PlantListActivity extends AppCompatActivity {
    private PlantDatabaseHelper dbHelper;
    private RecyclerView recyclerView;
    private PlantAdapter adapter;
    private List<Plant> plantList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant_list);

        dbHelper = new PlantDatabaseHelper(this);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        plantList = new ArrayList<>();
        adapter = new PlantAdapter(plantList);
        recyclerView.setAdapter(adapter);

        loadPlants();
    }

    private void loadPlants() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query("plants", null, null, null, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndex("id"));
                String name = cursor.getString(cursor.getColumnIndex("name"));
                String variety = cursor.getString(cursor.getColumnIndex("variety"));
                boolean isGreenhousePlant = cursor.getInt(cursor.getColumnIndex("isGreenhousePlant")) == 1;

                plantList.add(new Plant(id, name, variety, isGreenhousePlant));
            } while (cursor.moveToNext());
        }
        cursor.close();
        adapter.notifyDataSetChanged();
    }
}
