package com.example.kerbe.timetablee;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

public class DelActivity extends AppCompatActivity {
    GridView gv_del;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_del);
        gv_del = (GridView) findViewById(R.id.gv_del);
        //gv_del.setOnItemSelectedListener();
    }
}
