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

public class FinActivity extends AppCompatActivity {
    ImageView dv_f_i, wv_f_i, n_f_i, ex_f_i, fin_f_i;
    String[] s= {
            "charger                                  -1200",
            "doner                                        -600",
            "film                                         -1000",
            "card                                    +10000","charger                                  -1200",
            "doner                                        -600",
            "film                                         -1000",
            "card                                    +10000","charger                                  -1200",
            "doner                                        -600",
            "film                                         -1000",
            "card                                    +10000","charger                                  -1200",
            "doner                                        -600",
            "film                                         -1000",
            "card                                    +10000",};
    GridView gv_f;
    ArrayAdapter<String> ad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fin);

        dv_f_i = (ImageView) findViewById(R.id.dv_f_i);
        wv_f_i = (ImageView) findViewById(R.id.wv_f_i);
        n_f_i = (ImageView) findViewById(R.id.n_f_i);
        ex_f_i = (ImageView) findViewById(R.id.ex_f_i);
        fin_f_i = (ImageView) findViewById(R.id.fin_f_i);
        gv_f = (GridView) findViewById(R.id.gv_f);

        FinActivity mA = (FinActivity.this);
        mA.setActionBarColor(Color.parseColor("#A3D2E1"));
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar);

        ad = new ArrayAdapter<String>(this, R.layout.item_fin, R.id.tx_m, s);
        gv_f.setAdapter(ad);
        forGrid();

        dv_f_i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(FinActivity.this, DayViewActivity.class);
                startActivity(in);

            }
        });
        wv_f_i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(FinActivity.this, WeekViewActivity.class);
                startActivity(in);

            }
        });
        n_f_i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(FinActivity.this, NoteActivity.class);
                startActivity(in);

            }
        });
        ex_f_i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(FinActivity.this, ExamActivity.class);
                startActivity(in);

            }
        });
        fin_f_i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(FinActivity.this, FinActivity.class);
                startActivity(in);

            }
        });
    }

    private void forGrid() {

        gv_f.setNumColumns(1);
    }

    public void setActionBarColor(int parsedColor) {
        ActionBar mActionBar = getSupportActionBar();
        mActionBar.setBackgroundDrawable(new ColorDrawable(parsedColor));
        mActionBar.setDisplayShowTitleEnabled(false);
        mActionBar.setDisplayShowTitleEnabled(true);
    }

}
