package com.loibv.vivudalat.activities;

import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.loibv.vivudalat.adapters.ListAdapter;
import com.loibv.vivudalat.model.Place;
import com.loibv.vivudalat.R;

import java.util.ArrayList;
import java.util.List;

public class ExploreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore);

        final List<Place> placeList = new ArrayList();
        String[] placeNames = getResources().getStringArray(R.array.places);
        final String[] placeExplains = getResources().getStringArray(R.array.place_explains);
        final TypedArray placeImages = getResources().obtainTypedArray(R.array.imgs);

        for (int i = 0; i < 5; i++) {
            placeList.add(new Place(placeNames[i], placeImages.getResourceId(i, -1)));
        }
        ListView lv = (ListView) findViewById(R.id.lv);
        ListAdapter adapter = new ListAdapter(getApplicationContext(), R.layout.lv_item);
        adapter.addAll(placeList);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ExploreActivity.this, ViewPlaceActivity.class);
                intent.putExtra(ViewPlaceActivity.PLACE_BACKGROUND, placeImages.getResourceId(position, -1));
                intent.putExtra(ViewPlaceActivity.PLACE_EXPLAIN, placeExplains[position]);
                startActivity(intent);
            }
        });

    }
}
