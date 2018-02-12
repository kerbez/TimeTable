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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
        import android.widget.GridView;
        import android.widget.ImageView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class WeekViewActivity extends AppCompatActivity {
    ImageView dv_w_i, wv_w_i, n_w_i, ex_w_i, fin_w_i;
    Map<String, Integer> m = new HashMap<String, Integer>();
    Map<String, Integer> m_d = new HashMap<String, Integer>();

    //String[] time = {"8:00", "9:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00", "23:00"};
    String[] data = {"8:00", "", "", "", "", "", "", "",
            "9:00", "", "", "", "", "", "", "",
            "10:00", "", "", "", "", "", "", "",
            "11:00", "", "", "", "", "", "", "",
            "12:00",  "", "", "", "", "", "", "",
            "13:00", "", "", "", "", "", "", "",
            "14:00", "", "", "", "", "", "", "",
            "15:00", "", "", "", "", "", "", "",
            "16:00", "", "", "", "", "", "", "",
            "17:00", "", "", "", "", "", "", "",
            "18:00","", "", "", "", "", "", "",
            "19:00","", "", "", "", "", "", "",
            "20:00","", "", "", "", "", "", "",
            "21:00","", "", "", "", "", "", "",
            "22:00","", "", "", "", "", "", "",
            "23:00","", "", "", "", "", "", "",};
    int[] ids = {0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0,
                    };

    GridView week_gv, hour_gv;
    ArrayAdapter<String> adapter_week, adapter_hour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week_view);
        m.put("8:00", 1); m.put("9:00", 2); m.put("10:00", 3); m.put("11:00", 4); m.put("12:00", 5); m.put("13:00", 6); m.put("14:00", 7); m.put("15:00", 8);m.put("16:00", 9); m.put("17:00", 10); m.put("18:00", 11); m.put("19:00", 12);m.put("20:00", 13); m.put("21:00", 14); m.put("22:00", 15); m.put("23:00", 16);
        m_d.put("Monday", 7); m_d.put("Tuesday", 6);m_d.put("Wednesday", 5);m_d.put("Thusday", 4);m_d.put("Friday", 3);m_d.put("Saturday", 2);m_d.put("Sunday", 1);
        WeekViewActivity mA = (WeekViewActivity.this);
        mA.setActionBarColor(Color.parseColor("#A3D2E1"));
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar);
        //adapter_hour = new ArrayAdapter<String>(this, R.layout.item, R.id.tx, time);
        //hour_gv = (GridView) findViewById(R.id.hour_gv);
        week_gv = (GridView) findViewById(R.id.week_gv);
        //hour_gv.setAdapter(adapter_hour);
        adjustGridView();

        final TTDatabaseHelper db = new TTDatabaseHelper(this);
        try {
            List<DandW> dws = db.getAllDandW();
            Log.d("hey", db.getDWCount() + "");
            Log.d("intry", "all dws taken");
            for (DandW a : dws) {
                int pos = m.get(a.getHour()) * 8 - m_d.get(a.getDay());
                if(ids[pos] != 0){continue;}
                ids[pos] = a.getId();
                data[pos] = a.getDes();
                adapter_week = new ArrayAdapter<String>(this, R.layout.item, R.id.tx, data);
                week_gv.setAdapter(adapter_week);
                String log = "id = " + a.getId() + ", des = " + a.getDes() + ", day = " + a.getDay() + ", hour = " + a.getHour() + ", c = " + a.getC();
                Log.d("hey ::", log);
            }

        }catch(SQLiteException e){
            //Toast toast = Toast.makeText(this, "error", Toast.LENGTH_SHORT);
            //toast.show();
        }

        dv_w_i = (ImageView) findViewById(R.id.dv_w_i);
        wv_w_i = (ImageView) findViewById(R.id.wv_w_i);
        n_w_i = (ImageView) findViewById(R.id.n_w_i);
        ex_w_i = (ImageView) findViewById(R.id.ex_w_i);

        dv_w_i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(WeekViewActivity.this, DayViewActivity.class);
                startActivity(in);

            }
        });
        wv_w_i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(WeekViewActivity.this, WeekViewActivity.class);
                startActivity(in);

            }
        });
        n_w_i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(WeekViewActivity.this, NoteActivity.class);
                startActivity(in);

            }
        });
        ex_w_i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(WeekViewActivity.this, ExamActivity.class);
                startActivity(in);

            }
        });
        week_gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(ids[position] != 0 ){
                    Intent intent = new Intent(WeekViewActivity.this, dvViewActivity.class);
                    intent.putExtra("id", "" + ids[position]);
                    startActivity(intent);
                }
                Toast.makeText(getBaseContext(), "position = " + position + ", id = " + id, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void adjustGridView() {

        week_gv.setNumColumns(8);

    }

    public void setActionBarColor(int parsedColor) {
        ActionBar mActionBar = getSupportActionBar();
        mActionBar.setBackgroundDrawable(new ColorDrawable(parsedColor));
        mActionBar.setDisplayShowTitleEnabled(false);
        mActionBar.setDisplayShowTitleEnabled(true);
    }
}
