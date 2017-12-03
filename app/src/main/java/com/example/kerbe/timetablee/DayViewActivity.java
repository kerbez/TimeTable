package com.example.kerbe.timetablee;

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
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DayViewActivity extends AppCompatActivity {
    ImageView wv_d_i, dv_d_i, n_d_i, ex_d_i, fin_d_i, refresh;
    GridView gv_d;
    Spinner sp_day;
    Button plus, del;
    //TTDatabaseHelper db;
    String[] days = {"Monday", "Tuesday", "Wednesday", "Thusday", "Friday", "Saturday", "Sunday"};
    List<Integer> ids = new ArrayList<>();
    //String[] s;// = {"homewort electronics", "mid statistics", "film", "fitness" ,"homewort electronics", "mid statistics", "film", "fitness" ,"homewort electronics", "mid statistics", "film", "fitness" ,"homewort electronics", "mid statistics", "film", "fitness" };
    List<String> s = new ArrayList<>();
    ArrayAdapter<String> ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_view);

        final TTDatabaseHelper db = new TTDatabaseHelper(this);

        DayViewActivity mA = (DayViewActivity.this);
        mA.setActionBarColor(Color.parseColor("#A3D2E1"));
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar);
        plus = (Button) findViewById(R.id.plus);
        sp_day = (Spinner) findViewById(R.id.sp_day);
        wv_d_i = (ImageView) findViewById(R.id.wv_d_i);
        dv_d_i = (ImageView) findViewById(R.id.dv_d_i);
        n_d_i = (ImageView) findViewById(R.id.n_d_i);
        ex_d_i = (ImageView) findViewById(R.id.ex_d_i);
        fin_d_i = (ImageView) findViewById(R.id.fin_d_i);
       // refresh = (ImageView) findViewById(R.id.refresh);
        gv_d = (GridView) findViewById(R.id.gv_day);

        ad = new ArrayAdapter<String>(mA, R.layout.item_d, R.id.tx_d, s);
        gv_d.setAdapter(ad);
        forGrid();

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DayViewActivity.this, PlusActivity.class);
                startActivity(intent);
            }
        });
        dv_d_i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(DayViewActivity.this, DayViewActivity.class);
                startActivity(in);

            }
        });
        wv_d_i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(DayViewActivity.this, WeekViewActivity.class);
                startActivity(in);

            }
        });
        n_d_i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(DayViewActivity.this, NoteActivity.class);
                startActivity(in);

            }
        });
        ex_d_i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(DayViewActivity.this, ExamActivity.class);
                startActivity(in);

            }
        });
        fin_d_i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(DayViewActivity.this, FinActivity.class);
                startActivity(in);

            }
        });
        ArrayAdapter<String> from_adapter = new ArrayAdapter<String>(this, R.layout.spinner_item, days);
        from_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_day.setAdapter(from_adapter);
        sp_day.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                try {
                    List<DandW> dws = db.getAllDandW();
                    Log.d("hey", db.getDWCount() + "");
                    Log.d("intry", "all dws taken");
                    s.clear();
                    ids.clear();
                    for (DandW a : dws) {
                        Log.d("hey", days[position] + " ?= " + a.getDay());
                        if(a.getDay().equals(days[position])){

                            Log.d("hey", days[position] + " == " + a.getDay());
                            s.add(a.getDes());
                            ids.add(a.getId());

                        }
                        ad = new ArrayAdapter<String>(DayViewActivity.this, R.layout.item_d, R.id.tx_d, s);
                        gv_d.setAdapter(ad);

                        //Log.d("infor", "here");
                        String log = "id = " + a.getId() + ", des = " + a.getDes() + ", day = " + a.getDay() + ", hour = " + a.getHour() + ", c = " + a.getC();
                        Log.d("hey ::", log);
                    }

                }catch(SQLiteException e){
                    //Toast toast = Toast.makeText(this, "error", Toast.LENGTH_SHORT);
                    //toast.show();
                }
                Toast.makeText(getBaseContext(), "Position = " + position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        gv_d.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(), "text = " + s.get(position) + ", id = " + ids.get(position), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(DayViewActivity.this, dvViewActivity.class);
                intent.putExtra("id", ""+ids.get(position));
                startActivity(intent);
            }
        });

    }

    private void forGrid() {
        gv_d.setNumColumns(1);
        gv_d.setVerticalSpacing(5);
        gv_d.setHorizontalSpacing(5);
    }

    public void setActionBarColor(int parsedColor) {
        ActionBar mActionBar = getSupportActionBar();
        mActionBar.setBackgroundDrawable(new ColorDrawable(parsedColor));
        mActionBar.setDisplayShowTitleEnabled(false);
        mActionBar.setDisplayShowTitleEnabled(true);
    }
}