package com.example.kerbe.timetablee;

import android.content.Intent;
        import android.graphics.Color;
        import android.graphics.drawable.ColorDrawable;
        import android.support.v7.app.ActionBar;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Adapter;
        import android.widget.ArrayAdapter;
        import android.widget.GridView;
        import android.widget.ImageView;

public class NoteActivity extends AppCompatActivity {
    ImageView dv_n_i, wv_n_i, n_n_i, ex_n_i, fin_n_i;
    GridView gv_n_l, gv_n_b;
    String[] little = {"buy stickers", "wash t-shirt", "charge powerbank", "buy stickers", "wash t-shirt", "charge powerbank", "buy stickers", "wash t-shirt", "charge powerbank", "buy stickers", "wash t-shirt", "charge powerbank", "buy stickers", "wash t-shirt", "charge powerbank", "buy stickers", "wash t-shirt", "charge powerbank", "buy stickers", "wash t-shirt", "charge powerbank", "buy stickers", "wash t-shirt", "charge powerbank", "buy stickers", "wash t-shirt", "charge powerbank"};
    String[] big = {"enter Unist", "earn 1000$", "buy makbook","enter Unist", "earn 1000$", "buy makbook","enter Unist", "earn 1000$", "buy makbook","enter Unist", "earn 1000$", "buy makbook","enter Unist", "earn 1000$", "buy makbook"};
    ArrayAdapter<String> ad_l, ad_b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        dv_n_i = (ImageView) findViewById(R.id.dv_n_i);
        wv_n_i = (ImageView) findViewById(R.id.wv_n_i);
        n_n_i = (ImageView) findViewById(R.id.n_n_i);
        ex_n_i = (ImageView) findViewById(R.id.ex_n_i);
        fin_n_i = (ImageView) findViewById(R.id.fin_n_i);
        gv_n_l = (GridView) findViewById(R.id.gv_n_l);
        gv_n_b = (GridView) findViewById(R.id.gv_n_b);

        NoteActivity mA = (NoteActivity.this);
        mA.setActionBarColor(Color.parseColor("#A3D2E1"));
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.action_bar);


        ad_l = new ArrayAdapter<String>(this, R.layout.item_notes, R.id.tx_n, little);
        gv_n_l.setAdapter(ad_l);
        ad_b = new ArrayAdapter<String>(this, R.layout.item_notes, R.id.tx_n, big);
        gv_n_b.setAdapter(ad_b);
        forGrid();

        dv_n_i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(NoteActivity.this, DayViewActivity.class);
                startActivity(in);

            }
        });
        wv_n_i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(NoteActivity.this, WeekViewActivity.class);
                startActivity(in);

            }
        });
        n_n_i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(NoteActivity.this, NoteActivity.class);
                startActivity(in);

            }
        });
        ex_n_i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(NoteActivity.this, ExamActivity.class);
                startActivity(in);

            }
        });
        fin_n_i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(NoteActivity.this, FinActivity.class);
                startActivity(in);

            }
        });
    }

    private void forGrid() {
        gv_n_l.setNumColumns(2);
        gv_n_l.setVerticalSpacing(5);
        gv_n_l.setHorizontalSpacing(5);

        gv_n_b.setNumColumns(2);
        gv_n_b.setVerticalSpacing(5);
        gv_n_b.setHorizontalSpacing(5);
    }

    public void setActionBarColor(int parsedColor) {
        ActionBar mActionBar = getSupportActionBar();
        mActionBar.setBackgroundDrawable(new ColorDrawable(parsedColor));
        mActionBar.setDisplayShowTitleEnabled(false);
        mActionBar.setDisplayShowTitleEnabled(true);
    }

}
