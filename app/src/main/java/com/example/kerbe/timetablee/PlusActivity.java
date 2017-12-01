package com.example.kerbe.timetablee;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class PlusActivity extends AppCompatActivity {
    Button plusADD;
    EditText desET, dayET, hourET;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plus);

        PlusActivity mA = (PlusActivity.this);
        mA.setActionBarColor(Color.parseColor("#A3D2E1"));
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar);
        plusADD = (Button) findViewById(R.id.plusADD);
        desET = (EditText) findViewById(R.id.desET);
        dayET = (EditText) findViewById(R.id.dayET);
        hourET = (EditText) findViewById(R.id.hourET);
        final TTDatabaseHelper db = new TTDatabaseHelper(this);
        plusADD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    List<DandW> dws = db.getAllDandW();
                    Log.d("hey", "plus pressed");
                    db.insertTT(desET.getText().toString(), dayET.getText().toString(), hourET.getText().toString(), "1");

                    Log.d("hey", "successfully added");

                    Toast.makeText(getBaseContext(),"successfully added" , Toast.LENGTH_SHORT).show();

                }catch(SQLiteException e){
                    //Toast toast = Toast.makeText(this, "error", Toast.LENGTH_SHORT);
                    //toast.show();
                }
            }
        });
    }
    public void setActionBarColor(int parsedColor) {
        ActionBar mActionBar = getSupportActionBar();
        mActionBar.setBackgroundDrawable(new ColorDrawable(parsedColor));
        mActionBar.setDisplayShowTitleEnabled(false);
        mActionBar.setDisplayShowTitleEnabled(true);
    }
}
