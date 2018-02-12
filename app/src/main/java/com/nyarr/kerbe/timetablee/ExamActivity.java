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
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ExamActivity extends AppCompatActivity {
    ImageView dv_e_i, wv_e_i, n_e_i, ex_e_i, fin_e_i;
    GridView gv_e_t, gv_e_e;
    List<String> exams = new ArrayList<>();
    List<String> tasks = new ArrayList<>();
    TextView e_plus;
    List<Integer> id_e = new ArrayList<>();
    List<Integer> id_t = new ArrayList<>();
    ArrayAdapter<String> ad_t, ad_e;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);
        e_plus = (TextView) findViewById(R.id.e_plus);
        dv_e_i = (ImageView) findViewById(R.id.dv_e_i);
        wv_e_i = (ImageView) findViewById(R.id.wv_e_i);
        n_e_i = (ImageView) findViewById(R.id.n_e_i);
        ex_e_i = (ImageView) findViewById(R.id.ex_e_i);
        gv_e_t = (GridView) findViewById(R.id.gv_e_t);
        gv_e_e = (GridView) findViewById(R.id.gv_e_e);



        ExamActivity mA = (ExamActivity.this);
        mA.setActionBarColor(Color.parseColor("#A3D2E1"));
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar);
        final NoteDatabaseHelper db = new NoteDatabaseHelper(this);
        try {
            List<Note> nts = db.getAllNote();
            Log.d("hey", db.getNoteCount() + "");
            Log.d("intry", "all nts taken");
            for (Note a : nts) {
                if(a.getType().equals("task")){
                    tasks.add(a.getDes());
                    id_t.add(a.getId());
                }
                else if(a.getType().equals("exam")){
                    exams.add(a.getDes());
                    id_e.add(a.getId());
                }
                String log = "id = " + a.getId() + ", des = " + a.getDes() + ", day = " + a.getType();
                Log.d("hey ::", log);
            }
            ad_t = new ArrayAdapter<String>(this, R.layout.item_notes, R.id.tx_n, tasks);
            gv_e_t.setAdapter(ad_t);
            ad_e = new ArrayAdapter<String>(this, R.layout.item_notes, R.id.tx_n, exams);
            gv_e_e.setAdapter(ad_e);
            forGrid();

        }catch(SQLiteException e){
            //Toast toast = Toast.makeText(this, "error", Toast.LENGTH_SHORT);
            //toast.show();
        }
        e_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ExamActivity.this, NotePlusActivity.class);
                intent.putExtra("a", "1");
                startActivity(intent);
            }
        });
        gv_e_t.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                db.delete(""+id_t.get(position));
                Intent in = new Intent(ExamActivity.this, ExamActivity.class);
                startActivity(in);
            }
        });
        gv_e_e.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                db.delete(""+id_e.get(position));
                Intent in = new Intent(ExamActivity.this, ExamActivity.class);
                startActivity(in);
            }
        });
        dv_e_i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(ExamActivity.this, DayViewActivity.class);
                startActivity(in);

            }
        });
        wv_e_i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(ExamActivity.this, WeekViewActivity.class);
                startActivity(in);

            }
        });
        n_e_i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(ExamActivity.this, NoteActivity.class);
                startActivity(in);

            }
        });
        ex_e_i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(ExamActivity.this, ExamActivity.class);
                startActivity(in);

            }
        });

    }

    private void forGrid() {
        gv_e_t.setNumColumns(1);
        gv_e_t.setVerticalSpacing(5);
        gv_e_t.setHorizontalSpacing(5);

        gv_e_e.setNumColumns(1);
        gv_e_e.setVerticalSpacing(5);
        gv_e_e.setHorizontalSpacing(5);
    }

    public void setActionBarColor(int parsedColor) {
        ActionBar mActionBar = getSupportActionBar();
        mActionBar.setBackgroundDrawable(new ColorDrawable(parsedColor));
        mActionBar.setDisplayShowTitleEnabled(false);
        mActionBar.setDisplayShowTitleEnabled(true);
    }

}
