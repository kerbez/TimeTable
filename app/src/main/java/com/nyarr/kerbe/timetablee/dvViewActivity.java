package com.nyarr.kerbe.timetablee;

import android.content.Intent;
import android.database.sqlite.SQLiteException;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class dvViewActivity extends AppCompatActivity {
    TextView one_des, one_day, one_hour;
    Button one_del;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dv_view);

        dvViewActivity mA = (dvViewActivity.this);
        mA.setActionBarColor(Color.parseColor("#A3D2E1"));
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar);
        one_des = (TextView) findViewById(R.id.one_des);
        one_day = (TextView) findViewById(R.id.one_day);
        one_hour = (TextView) findViewById(R.id.one_hour);
        one_del = (Button) findViewById(R.id.one_del);

        final TTDatabaseHelper db = new TTDatabaseHelper(this);
        final int id = Integer.parseInt(getIntent().getStringExtra("id"));

        final List<DandW> dws = db.getAllDandW();
        try {
            Log.d("hey", db.getDWCount() + "");
            Log.d("intry", "all dws taken");
            for (DandW a : dws) {
                if(id == a.getId()){
                    one_des.setText(a.getDes());
                    one_day.setText(a.getDay());
                    one_hour.setText(a.getHour());
                }
                String log = "id = " + a.getId() + ", des = " + a.getDes() + ", day = " + a.getDay() + ", hour = " + a.getHour() + ", c = " + a.getC();
                Log.d("hey ::", log);
            }

        }catch(SQLiteException e){
            //Toast toast = Toast.makeText(this, "error", Toast.LENGTH_SHORT);
            //toast.show();
        }
        one_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (DandW a : dws) {
                    if(id == a.getId()){
                        db.delete(id +"");
                        Toast.makeText(getBaseContext(), "successfully deleted", Toast.LENGTH_SHORT).show();
                    }
                    String log = "id = " + a.getId() + ", des = " + a.getDes() + ", day = " + a.getDay() + ", hour = " + a.getHour() + ", c = " + a.getC();
                    Log.d("hey ::", log);
                }
                Intent intent = new Intent(dvViewActivity.this, DayViewActivity.class);
                startActivity(intent);
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
