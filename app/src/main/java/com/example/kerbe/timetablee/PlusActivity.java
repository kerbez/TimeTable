package com.example.kerbe.timetablee;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

public class PlusActivity extends AppCompatActivity {
    Button plusADD;
    EditText desET, hourET;
    Spinner dayET;
    String[] days = {"Monday", "Tuesday", "Wednesday", "Thusday", "Friday", "Saturday", "Sunday"};
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
        dayET = (Spinner) findViewById(R.id.dayET);
        hourET = (EditText) findViewById(R.id.hourET);
        final TTDatabaseHelper db = new TTDatabaseHelper(this);

        ArrayAdapter<String> from_adapter = new ArrayAdapter<String>(this, R.layout.spinner_item, days);
        from_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dayET.setAdapter(from_adapter);
        plusADD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    List<DandW> dws = db.getAllDandW();
                    Log.d("hey", "plus pressed");
                    db.insertTT(desET.getText().toString(), dayET.getSelectedItem().toString(), hourET.getText().toString(), "1");

                    Log.d("hey", "successfully added");

                    Toast.makeText(getBaseContext(),"successfully added" , Toast.LENGTH_SHORT).show();
                    Intent in = new Intent(PlusActivity.this, DayViewActivity.class);
                    startActivity(in);

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
