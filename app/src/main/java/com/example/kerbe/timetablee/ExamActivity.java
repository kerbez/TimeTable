package com.example.kerbe.timetablee;


import android.content.Intent;
        import android.graphics.Color;
        import android.graphics.drawable.ColorDrawable;
        import android.support.v7.app.ActionBar;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.ArrayAdapter;
        import android.widget.GridView;
        import android.widget.ImageView;

public class ExamActivity extends AppCompatActivity {
    ImageView dv_e_i, wv_e_i, n_e_i, ex_e_i, fin_e_i;
    GridView gv_e_t, gv_e_e;
    String[] tasks = {"Hw statiks", "graph 1-6 ex", "electronics pre lab","android project","Hw statiks", "graph 1-6 ex", "electronics pre lab","android project","Hw statiks", "graph 1-6 ex", "electronics pre lab","android project","Hw statiks", "graph 1-6 ex", "electronics pre lab","android project"};
    String[] exams = {"mid electronics", "graph quiz", "web mid", "android mid","mid electronics", "graph quiz", "web mid", "android mid","mid electronics", "graph quiz", "web mid", "android mid","mid electronics", "graph quiz", "web mid", "android mid"};
    ArrayAdapter<String> ad_t, ad_e;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam);

        dv_e_i = (ImageView) findViewById(R.id.dv_e_i);
        wv_e_i = (ImageView) findViewById(R.id.wv_e_i);
        n_e_i = (ImageView) findViewById(R.id.n_e_i);
        ex_e_i = (ImageView) findViewById(R.id.ex_e_i);
        fin_e_i = (ImageView) findViewById(R.id.fin_e_i);
        gv_e_t = (GridView) findViewById(R.id.gv_e_t);
        gv_e_e = (GridView) findViewById(R.id.gv_e_e);


        ad_t = new ArrayAdapter<String>(this, R.layout.item_notes, R.id.tx_n, tasks);
        gv_e_t.setAdapter(ad_t);
        ad_e = new ArrayAdapter<String>(this, R.layout.item_notes, R.id.tx_n, exams);
        gv_e_e.setAdapter(ad_e);
        forGrid();

        ExamActivity mA = (ExamActivity.this);
        mA.setActionBarColor(Color.parseColor("#A3D2E1"));
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar);

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
        fin_e_i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(ExamActivity.this, FinActivity.class);
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
